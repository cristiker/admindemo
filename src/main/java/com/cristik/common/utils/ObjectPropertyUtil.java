package com.cristik.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhenghua on 2016/5/5.
 */
public class ObjectPropertyUtil {

    public static Object copyProperty(Object fromObject,Object toObject){
        Class fromObjectClass = fromObject.getClass();
        Class toObjectClass = toObject.getClass();
        Method[] fMethods = fromObjectClass.getMethods();
        Method[] tMethods = toObjectClass.getMethods();
        for(Method fmethod : fMethods){
            if(fmethod.getName().startsWith("get")&&!fmethod.getName().equals("getClass")){
                for(Method tmethod : tMethods){
                    if(fmethod.getName().replaceFirst("get","set").equals(tmethod.getName())){
                        try {
                            tmethod.invoke(toObject,fmethod.invoke(fromObject,null));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return toObject;
    }

    public static Object copyNotNullProperty(Object fromObject,Object toObject){
        Class fromObjectClass = fromObject.getClass();
        Class toObjectClass = toObject.getClass();
        Method[] fMethods = fromObjectClass.getMethods();
        Method[] tMethods = toObjectClass.getMethods();
        for(Method fmethod : fMethods){
            if(fmethod.getName().startsWith("get")&&!fmethod.getName().equals("getClass")){
                for(Method tmethod : tMethods){
                    if(fmethod.getName().replaceFirst("get","set").equals(tmethod.getName())){
                        try {
                            if(fmethod.invoke(fromObject,null)!=null){
                                tmethod.invoke(toObject,fmethod.invoke(fromObject,null));
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return toObject;
    }
}
