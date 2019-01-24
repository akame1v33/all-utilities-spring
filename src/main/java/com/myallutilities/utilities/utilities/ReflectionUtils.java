package com.myallutilities.utilities.utilities;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class ReflectionUtils {
	private ReflectionUtils() {}

	public static Class<?> getGenericsAt(Class<?> clazz, int index) {
		Class<?> genericClass = null;
		try {
			genericClass = Class.forName(ReflectionUtils.getActualTypeArgument(clazz, index).toString().split("\\s")[1]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genericClass;
	}
	public static Class<?> getFirstGenerics(Class<?> clazz) {
		Class<?> genericClass = null;
		try {
			genericClass = Class.forName(ReflectionUtils.getActualTypeArgument(clazz, 0).toString().split("\\s")[1]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genericClass;
	}
	public static Type getActualTypeArgument(Class<?> clazz, int index) {
		Type superClassType = clazz.getGenericSuperclass();
		return ((ParameterizedType)superClassType).getActualTypeArguments()[index];
	}


//	public static List<Method> getMethod(Object object) {
//
//		Class<?> clazz = object.getClass();
//		Arrays.stream( clazz.getDeclaredFields() )
//	}
}
