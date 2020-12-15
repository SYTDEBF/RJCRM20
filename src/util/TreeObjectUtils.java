package util;

import util.TreeType;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.lang.reflect.Field;

/**
 * @author ***
 * @version 1.0
 * @date 2020/7/28 15:47
 */
public class TreeObjectUtils<T> {

    //主键id字段名
    private String id;
    //父级id字段名
    private String parentId;
    //子级集合字段名
    private String child;
    //等级集合,从高到底。如：1，2，3
    private List<String> level;
    //等级字段名
    private String levelName;
    //key父id
    //value索引
    private Map<Object, Integer> map = null;
    /**
     * 获取树形结构
     * @param list
     * @param <T>
     * @param <E>
     * @return
     */
    public <T, E> List<T> get1(List<T> list) {
        if (null == list) {
            return list;
        }
        int size = list.size();
        if (size == 0) {
            return list;
        }
        getType(list.get(0));
        map = new HashMap<>(list.size());
        int levelSize = level.size();
        Map<Object, List<T>> levelMap = new HashMap<>(levelSize);
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            Object key = getName(id, t, null);
            Object mapLevel = getName(levelName, t, null);
            List<T> levelLists = levelMap.get(mapLevel);
            Integer index = null;
            if (null == levelLists) {
                List<T> levelList = new ArrayList<>();
                index = 0;
                levelList.add(t);
                levelMap.put(mapLevel, levelList);
            } else {
                index = levelLists.size();
                levelLists.add(t);
                levelMap.put(mapLevel, levelLists);
            }
            map.put(key, index);
        }
        for (int i = levelSize - 1; i > 0; i--) {

            List<T> levelLists = levelMap.get(level.get(i));
            //System.out.println(i);
            int size1 = levelLists.size();
            for (int j = 0; j < size1; j++) {
                T unit = levelLists.get(j);
                //获取父级id
                Object key = getName(parentId, unit, null);
                //获取索引id
                Integer integer = map.get(key);
                //获取上一级对象
                List<T> tList = levelMap.get(level.get(i - 1));
                T t = tList.get(integer);
                List childList = (List) getName(child, t, null);
                if (null == childList) {
                    childList = new ArrayList<>();
                }
                childList.add(unit);
                getName(child, t, childList);
            }
        }
        return levelMap.get(level.get(0));
    }

    /**
     * 通过反射获取注解对应的字段名
     *
     * @param t
     */
    public <T> void getType(T t) {
        // 反射获得 class
        Class<?> clazz = t.getClass();
        // 如果类  上有注解 @TreeType ，取出注解 value的值
        TreeType declaredAnnotation = clazz.getDeclaredAnnotation(TreeType.class);
        if (declaredAnnotation != null) {
            System.out.println("类的注解@TreeType的value值是：" + declaredAnnotation.value());
        }
        //获得所有该类方法，不包括从其他地方继承过来的
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            TreeType fieldAnnotation = declaredField.getDeclaredAnnotation(TreeType.class);
            if (fieldAnnotation != null) {
                String value = fieldAnnotation.value();
                String level = fieldAnnotation.level();
                String name = declaredField.getName();
                //首字母转大写，拼接get,set方法。反射调用不拼接，不使用
                //name=toUpperCaseFirstOne(name);
                if ("id".equals(value)) {
                    this.id = name;
                } else if ("pid".equals(value)) {
                    this.parentId = name;
                } else if ("list".equals(value)) {
                    this.child = name;
                } else if (!(level==null)) {

                    this.level = Arrays.asList(level.split(","));

                    this.levelName = name;
                }
            }
        }
    }

    /**
     * 通过反射调用方法获取参数
     *
     * @param name 方法名
     * @param obj  类
     * @param arg  参数
     * @return
     */
    private Object getName(String name, Object obj, Object arg) {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor(name, obj.getClass());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        //获取set方法
        Method getMethod = pd.getReadMethod();
        //获取get方法
        Method getMethod1 = pd.getWriteMethod();
        Object rtn = null;
        try {
            if (arg == null) {
                rtn = getMethod.invoke(obj);
            } else {
                getMethod1.invoke(obj, arg);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return rtn;
    }
}
