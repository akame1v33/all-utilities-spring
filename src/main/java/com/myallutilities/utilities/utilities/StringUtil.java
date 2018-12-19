package com.myallutilities.utilities.utilities;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class StringUtil {
    private StringUtil(){}


    public static String toTitlecase(String title){
        return Arrays.asList(title.split(" "))
                .stream()
                .map(part -> {
                    String stringPart = part;
                    if( part.length() > 2 ) {
                        stringPart  = part.substring(0,1).toUpperCase() + part.substring(1).toLowerCase();;
                    }

                    return stringPart;
                })
                .collect(Collectors.joining(" "));
    }

    public static double removeComma(String money) {
        if( money.equalsIgnoreCase("null") || money == null ) {
            return 0.00;
        }
        return Double.parseDouble(  money.replaceAll("\\,", "") );
    }


}
