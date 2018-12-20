package com.myallutilities.utilities.utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class StreamsUtil {

    private StreamsUtil(){}

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
    public static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> {
            return seen.add(keyExtractor.apply(t));
        };
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
