package com.xiaojiu.annotation.annotationdemo.middledemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseBean {

    public void verification() {
        //获取带有注释的属性
        Field[] fields = this.getClass().getDeclaredFields();
        //遍历属性集合
        for (Field field : fields) {
            //判断该属性上的注解是不是指定的注解类里面的
            if (field.isAnnotationPresent(ParamsRequired.class)) {

                //获取到注解的对象
                ParamsRequired paramsRequired = field.getAnnotation(ParamsRequired.class);
                //如果注解类的方法值 等于我们需要的
                if (paramsRequired.notNull()) {
                    //如果属性的类型等于字符串类型
                    // 如果type是类类型，则前面包含"class "，后面跟类名

                    if (field.getGenericType().toString().equals("class java.lang.String")) {
                        /**
                         * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的
                         * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX）
                         * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范
                         */
                        try {
                            //根据属性 获取到对应的get方法 get+属性第(第一个字母大写)
                            Method m = this.getClass().getMethod(
                                    "get" + getMethodName(field.getName()));
                            String val = (String) m.invoke(this);// 调用getter方法获取属性值
                            if (val == null || val.isEmpty()) {
                                System.out.println(field.getName() + " 不能为空!");
                            } else if (val != null) {
                                System.out.println("String type:" + val);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (field.getGenericType().toString().equals(
                            "int")) {
                        try {
                            Method m = this.getClass().getMethod(
                                    "get" + getMethodName(field.getName()));
                            Integer val = (Integer) m.invoke(this);// 调用getter方法获取属性值
                            if (val != null) {
                                System.out.println("String type:" + val);
                            } else {
                                System.out.println(field.getName() + " 不能为空!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

    }

    /**
     * 把一个字符串的第一个字母大写、效率是最高的、
     */
    private String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
