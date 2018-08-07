package com.yanziting.basiclearning.learningreflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 反射Demo
 *
 * @author : Ziting.Yan
 * @since : 2018-08-07-16-36
 **/
@Component
public class MyReflectDemo {

    private Class cl;
    private Class cl2;
    private Class cl3;

    public void tryReflect()
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        //获得Class
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        getMyClass();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");

        System.out.println("判断是否为某类，具体类.isInstance(classObject)：");
        //判断是否为某类
        System.out.println("\t" + cl.isInstance(new A()));

        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        createMyInstance();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        getMyMethod();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        getMyField();
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        testMyInvoke();
    }

    private void getMyClass() throws ClassNotFoundException {
        System.out.println("通过Class.forName来获取类，记得要包路径：");
        cl = Class.forName("com.yanziting.basiclearning.learningreflect.A");
        System.out.println("\t" + cl.getName());

        System.out.println("通过直接赋值：");
        cl2 = Sync.class;
        System.out.println("\t" + cl2.getName());

        System.out.println("通过对象.getClass()获得：");
        A a = new A();
        cl3 = a.getClass();
        System.out.println("\t" + cl3.getName());
    }

    /**
     * 创建Class的实例
     */
    private void createMyInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //方法一
        A a2 = (A) cl.newInstance();
        System.out.println(a2.getClass().getName());
        //方法二
        Constructor constructor = cl.getConstructor(String.class);
        A a3 = (A) constructor.newInstance("我是a3");
        System.out.println(a3.getName());
    }

    /**
     * 获取method
     */
    private void getMyMethod() throws NoSuchMethodException {
        //public Method[] getDeclaredMethods() throws SecurityException
        Method[] methods1 = B.class.getDeclaredMethods();
        System.out.println("-----B类的所有方法，包括公共、保护、默认和私有，但不包括继承 start------");
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        System.out.println("-----B类的所有方法，包括公共、保护、默认和私有，但不包括继承   end------" + "\n");

        //public Method[] getMethods() throws SecurityException
        Method[] methods2 = B.class.getMethods();
        System.out.println("-----B类的所有公有方法，包括继承类的公有方法 start------");
        for (Method method : methods2) {
            System.out.println(method.getName());
        }
        System.out.println("-----B类的所有公有方法，包括继承类的公有方法   end------" + "\n");

        //public Method getMethod(String name, Class<?>... parameterTypes)，其中parameterTypes为method中的参数类型
        System.out.println("-----B类中publicPrintMyName方法，只能为public，不能为其他访问级别，但可以是继承的 start-------");
        Method method3 = B.class.getMethod("publicPrintMyName");
        System.out.println(method3.getName());
        System.out.println("-----B类中publicPrintMyName方法，只能为public，不能为其他访问级别，但可以是继承的   end-------" + "\n");
    }

    /**
     * 获取类的成员变量
     */
    private void getMyField() throws NoSuchFieldException {
        //public Field[] getFields() throws SecurityException
        System.out.println("-----getFields 获取所有公有成员变量，包括继承来的 start--------");
        Field[] fields = B.class.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("-----getFields 获取所有公有成员变量，包括继承来的 end--------");

        //public Field[] getDeclaredFields() throws SecurityException
        System.out.println("----------getDeclaredFields 获取所有成员变量，不包括继承来的 start-------");
        Field[] fields1 = B.class.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("----------getDeclaredFields 获取所有成员变量，不包括继承来的 end-------");

        //public Field getField(String name) throws NoSuchFieldException, SecurityException
        System.out.println("------getField 获取本类、继承来的公有 start----------");
        Field field = B.class.getField("publicName");
        System.out.println(field.getName());
        System.out.println("------getField 获取本类、继承来的公有 end----------");

        //public Field getDeclaredField(String name) throws NoSuchFieldException, SecurityException
        System.out.println("-----getDeclaredField 获取本类所有 start---------");
        Field field1 = B.class.getDeclaredField("value");
        System.out.println(field1.getName());
        System.out.println("-----getDeclaredField 获取本类所有 end---------");
    }

    private void testMyInvoke() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = B.class;
        B b = (B) cls.newInstance();
        Method method = cls.getMethod("setValue", String.class, String.class);
        method.invoke(b," 我是value1"," 我是value2");
        System.out.println(b.getValue());
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

    private String name;
    public String publicName;

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

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }
}

class B extends A {

    private String value;
    public String publicValue;

    public void printMyName() {
        System.out.println("I'm class B");
    }

    public void publicPrintMyName() {
        System.out.println("I'm class B");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value1, String value2) {
        this.value = "我是默认值" + value1 + value2;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPublicValue() {
        return publicValue;
    }

    public void setPublicValue(String publicValue) {
        this.publicValue = publicValue;
    }
}