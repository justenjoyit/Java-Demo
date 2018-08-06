package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //获得Class
        Class cl = Class.forName("com.example.demo.A");
        System.out.println(cl.getName());
        Class cl2 = Sync.class;
        System.out.println(cl2.getName());
        A a = new A();
        Class cl3 = a.getClass();
        System.out.println(cl3.getName());

        //判断是否为某类
        System.out.println(cl.isInstance(new A()));

        //创建Class的实例
        //方法一
        A a2 = (A) cl.newInstance();
        System.out.println(a2.getClass().getName());
        //方法二
        Constructor constructor = cl.getConstructor(String.class);
        A a3 = (A) constructor.newInstance("我是a3");
        System.out.println(a3.getName());

        //得到Method
        //public Method[] getDeclaredMethods() throws SecurityException
        Method[] methods1 = B.class.getDeclaredMethods();
        System.out.println("-----B类的所有方法，包括公共、保护、默认和私有，但不包括继承 start------");
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        System.out.println("-----B类的所有方法，包括公共、保护、默认和私有，但不包括继承 end------" + "\n");

        //public Method[] getMethods() throws SecurityException
        Method[] methods2 = B.class.getMethods();
        System.out.println("-----B类的所有公有方法，包括继承类的公有方法 start------");
        for (Method method : methods2) {
            System.out.println(method.getName());
        }
        System.out.println("-----B类的所有公有方法，包括继承类的公有方法 end------" + "\n");

        //
        Method method3 = B.class.getMethod("privatePrintMyName");
        System.out.println(method3.getName());
    }

}

class Sync<T> {

    List<T> data;

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }
}

class A {

    String name;

    public A(String name) {
        this.name = name;
    }

    public A() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class B extends A {

    public void printMyName() {
        System.out.println("I'm class B");
    }

    public void privatePrintMyName() {
        System.out.println("I'm class B");
    }
}