package com.myallutilities.utilities.utilities;

import java.util.Objects;
import java.util.function.Predicate;

public interface ValidatorTest {



    static Predicate<String> required(){
        return (x) -> {
            if( x == null || x.length() == 0 ){
                return true;
            }
            return false;
        };
    }

    static Predicate<String> minLength(int minLength){
        Objects.requireNonNull(minLength);

        return (x) -> {
            if( minLength < x.length()  ){
                return true;
            }
            return false;
        };
    }
}
