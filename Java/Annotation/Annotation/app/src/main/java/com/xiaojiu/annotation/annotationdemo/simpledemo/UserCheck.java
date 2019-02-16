package com.xiaojiu.annotation.annotationdemo.simpledemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserCheck {

    public static boolean chechk(User user) {
        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        //Field[] fields = User.class.getDeclaredFields();
        //方法
        Method[] methods  = User.class.getMethods();
        for (Method method : methods)
        {
            // 如果此方法有注解，就把注解里面的数据赋值到user对象
            if (method.isAnnotationPresent(Init.class))
            {
                Init init = method.getAnnotation(Init.class);
                try {
                    method.invoke(user, init.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
