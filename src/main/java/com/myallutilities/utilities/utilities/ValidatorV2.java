package com.myallutilities.utilities.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class ValidatorV2<T> {

    public static <T> void validate(T entity, Map<String, List<Predicate<String>>> maps){
        Class object = entity.getClass();

        maps.entrySet().stream()
                .forEach( (keyAndValidators) -> {
                    String key = keyAndValidators.getKey();

                    Arrays.stream(object.getDeclaredFields())
                            .forEach(field -> {
                                try {
                                    String fieldName = field.getName();
                                    if( key.equalsIgnoreCase( fieldName ) ){
                                        Method m = object.getMethod(String.join("","get",StringUtil.toTitlecase( fieldName )));
                                        String methodValue =  (String) m.invoke(entity, null);


                                    }
                                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }

                            });

                } );
    }

}
