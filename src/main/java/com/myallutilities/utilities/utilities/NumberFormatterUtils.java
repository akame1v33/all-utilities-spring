package com.myallutilities.utilities.utilities;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public final class NumberFormatterUtils {

    private NumberFormatterUtils(){};



    public static String toNumberWithCommaWithoutDecimalPoint(Double num){
        DecimalFormat df2 = new DecimalFormat("#,###");
        return df2.format(num);
    }
    public static String toNumberWithCommaAndDecimalPoint(Double num){



        DecimalFormat df2 = new DecimalFormat("#,###.#");
        return df2.format(num);
    }
}
