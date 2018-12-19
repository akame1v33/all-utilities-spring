package com.myallutilities.utilities.utilities;

import java.util.List;
import java.util.stream.Stream;

public final class StreamUtil {

    private StreamUtil(){}

    public static <T> void print(List<? extends Object> source){
        source.forEach(r -> {
            if( r instanceof Object[] ){
                Object[] cols = (Object[]) r;
                Stream.of(cols).forEach(c -> {
                    System.out.print(c +"\t\t\t\t\t\t");
                });
                System.out.println();
            } else if ( r instanceof List){
                ((List) r).forEach(c -> {
                    System.out.print(c +"\t\t\t\t\t\t");
                });
                System.out.println();
            } else {

                System.out.println(r);
            }


        });
//        Stream.of(source)
//                .forEach(row -> {
//                    Stream.of(row).forEach(col -> {
//                                System.out.print(col + "\t\t\t\t\t\t");
//                            });
//                    System.out.println(row);
//                });
    }
//    public static void printList(List<List<Object>> source){
//        Stream.of(source)
//                .forEach(row -> {
//                    Stream.of(row).forEach(col -> {
//                        System.out.print(col + "\t\t\t\t\t\t");
//                    });
//                    System.out.println(row);
//                });
//    }
}
