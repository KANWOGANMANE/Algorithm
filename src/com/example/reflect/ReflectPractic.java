package com.example.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 总结：
 * 1.java反射可以通过Class.forName获取对象
 * 2.通过获取的对象调用getDeclaredMethods获取对象所有方法,getDeclaredMethods获取指定方法，返回一个对象Method，调用方法需要调用invoke方法
 * 3.通过getDeclaredField获取对象，private属性需要设置Accessible为true，private方法也一样
 * 4.静态代理并没有使用反射相关的技术，而是通过java多态来实现静态代理；首先定义一个接口，然后定义一个类实现接口，再定义一个代理类实现接口
 * 5.动态代理的实现方式有很多种，比如 JDK 动态代理、CGLIB 动态代理
 */

public class ReflectPractic {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 获取TargetObject类的Class对象并且创建TargetObject类实例
         * Class.forName方法遍历所在包的所有类
         */
        Class<?> targetclass = Class.forName("com.example.reflect.TargetObject");
        TargetObject targetObject = (TargetObject)targetclass.newInstance();

        /**
         * 获取所有类中定义的所有方法
         */
        System.out.println("----------------------获取所有类中定义的所有方法--------------------");
        Method[] methods = targetclass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("------------------------------------------------------------------");

        /**
         * 获取指定方法并调用
         */
        System.out.println("----------------------获取指定方法并调用--------------------");
        Method publicMethod = targetclass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"invoke publicMethod");
        System.out.println("-----------------------------------------------------------");

        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetclass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject,"change value by reflect");

        /**
         * 调用 private 方法
         */
        Method privateMethod = targetclass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
