package com.reflect;

import com.example.demo.DemoApplication;
import org.springframework.boot.SpringApplication;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class LocalJarLoader {

    public static void main(String[] args) {
        try {
            testClassLoader();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void testClassLoader2() throws FileNotFoundException {
        //src目录下，直接加载
        InputStream in1 = null;
        in1 = this.getClass().getClassLoader().getResourceAsStream("test1.txt");

        //放在内部文件夹，要写全路径
        InputStream in2 = null;
        in2 = this.getClass().getClassLoader().getResourceAsStream("com/atguigu/java/fanshe/test2.txt");
    }

    public static void testClassLoader() throws ClassNotFoundException, FileNotFoundException {
        //1. 获取一个系统的类加载器(可以获取，当前这个类PeflectTest就是它加载的)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);


        //2. 获取系统类加载器的父类加载器（扩展类加载器，可以获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);


        //3. 获取扩展类加载器的父类加载器（引导类加载器，不可获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);


        //4. 测试当前类由哪个类加载器进行加载（系统类加载器）:
        classLoader = Class.forName("com.reflect.LocalJarLoader")
                .getClassLoader();
        System.out.println(classLoader);


        //5. 测试 JDK 提供的 Object 类由哪个类加载器负责加载（引导类）
        classLoader = Class.forName("java.lang.Object")
                .getClassLoader();
        System.out.println(classLoader);
    }
}
//结果：
//sun.misc.Launcher$AppClassLoader@5ffdfb42
//sun.misc.Launcher$ExtClassLoader@1b7adb4a
//null
//sun.misc.Launcher$AppClassLoader@5ffdfb42
//null