package util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ***
 * @version 1.0
 * @date 2020/7/28 16:12
 * 树形封装注解
 * value：id     主键id
 *        pid   父级别id
 *        list  子列表
 * level：等级，由高到底，逗号分割
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface TreeType {
    //注解成员，default表示默认值
    public String value() default "";
    public String level() default "";
}
