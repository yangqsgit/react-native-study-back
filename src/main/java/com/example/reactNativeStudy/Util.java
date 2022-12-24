package com.example.reactNativeStudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Util {
    public static <T> T setDtoValFromEntity (Object o,T dto){

        try{
            Class dtoClass = dto.getClass();
            Field[] fields = dtoClass.getDeclaredFields();
            Class oClass = o.getClass();
            for (Field f:fields) {
                String upperCaseField = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                Method setFun = dtoClass.getMethod("set" + upperCaseField,f.getType());
                Method getFun = oClass.getMethod("get" + upperCaseField);
                setFun.invoke(dto,getFun.invoke(o));
            }
        }
        catch(NoSuchMethodException e) {
            System.out.println("----------------------setDtoValFromEntity catch NoSuchMethodException---------------------------------------------------------------");
            System.out.println(e.toString());
        }
        catch(InvocationTargetException e){
            System.out.println("----------------------setDtoValFromEntity catch InvocationTargetException---------------------------------------------------------------");
            System.out.println(e.toString());
        }
        catch(IllegalAccessException e){
            System.out.println("----------------------setDtoValFromEntity catch IllegalAccessException---------------------------------------------------------------");
            System.out.println(e.toString());
        }
        return dto;

    }
}
