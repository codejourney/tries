package com.reflect;

//import com.datajiang.wms.IWMArgorithm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.StandardSocketOptions;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class JarLoader {

    private static String softPath = "file:W:\\AAAAsiainfo\\unionlabs\\dataimprint\\docs\\imprint-lib.jar";

    @SuppressWarnings({"unchecked", "resource", "rawtypes"})
    public static void main(String[] args) throws Exception {

        Test1();
//        InvokeInterface();
    }

    public static void Test1() throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(softPath)}, Thread.currentThread().getContextClassLoader());

        String className = "com.datajiang.wms.Version";
        Class demo = classLoader.loadClass(className);
        Object object = demo.newInstance();

        Field m = demo.getField("build");
//        System.out.println(demo.getMethod("invoke",String.class).invoke(object,new Object[]{"amx"}));
        String val = m.get(object).toString();
        System.out.println(val);

        System.out.println(demo.getField("desc").get(object));


        String className1 = "com.datajiang.wms.WatermarkA11";
        Class demo1 = classLoader.loadClass(className1);
        Object a11 = demo1.newInstance();

        String source = "123456_789012_201806280011####";

        Method m1 = demo1.getMethod("CutID", String.class);
        String autual = (String) m1.invoke(a11, new Object[]{source});
        String expected = "123456_789012_201806280011";

        System.out.println(autual);
//        String actual = a11.CutID(source);
    }


//    public static void InvokeInterface() {
//        String className1 = "com.datajiang.wms.WatermarkA11";
//        Class demo1 = null;
//        try {
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL(softPath)}, Thread.currentThread().getContextClassLoader());
//
//            demo1 = classLoader.loadClass(className1);
//            Object a11object = demo1.newInstance();
//
//            IWMArgorithm a11 = (IWMArgorithm) a11object;
//
//            String source = "123456_789012_201806280011####";
//
//            String autual = a11.GetInfo();
//
//            System.out.println(autual);
//
//            String expected = "123456_789012_201806280011";
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
}
