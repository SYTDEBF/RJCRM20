package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    /**
     * 构造方法私有
     */
    private ReflectionUtils(){}
    /**
     * 	根据字段名称获取对象的属性
     * @param fieldName
     * @param target
     * @param <T>
     * @return
     * @throws Exception
     */
    public static Object getFieldValueByName(String fieldName, Object target) throws Exception {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + fieldName.substring(1);
        Method method = target.getClass().getMethod(getter, new Class[0]);
        Object e = method.invoke(target, new Object[0]);
        return e;
    }
    /**
     * 	获取所有字段名字
     * @param target
     * @return
     */
    public static String[] getFiledName(Object target) throws Exception {
        Field[] fields = target.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; ++i) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
    /**
     * 	获取所有属性的值
     * @param target
     * @return
     * @throws Exception
     */
    public static Object[] getFiledValues(Object target) throws Exception {
        String[] fieldNames = getFiledName(target);
        Object[] value = new Object[fieldNames.length];
        for (int i = 0; i < fieldNames.length; ++i) {
            value[i] = getFieldValueByName(fieldNames[i], target);
        }
        return value;
    }
}
