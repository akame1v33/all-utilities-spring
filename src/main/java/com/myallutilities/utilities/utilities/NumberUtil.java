package com.myallutilities.utilities.utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class NumberUtil {

    private NumberUtil(){}

    public static List<String> beautify(List<String> row) {
        return row.stream()
                .map(col -> {
                    if( String.valueOf(col).matches("^[0-9E\\.\\-]+$")  ) {
                        double number = Double.parseDouble( String.valueOf(col));

                        String string_number = NumberUtil.money( Math.abs(number) );

                        if( NumberUtil.isMoneyAndHasPoint(string_number)  ) {
                            string_number = string_number.substring(0, string_number.length()-2);

                        }

                        if( number < 0) {
                                return "("+string_number+")";
                        } else {
                                return string_number;
                        }
                    }


                    return col;
                })
                .collect(Collectors.toList());
    }
    public static List<String> beautify(List<String> row, List<Map<String, Integer>> columnIndexes) {

            AtomicInteger counter = new AtomicInteger(0);
//        System.out.println("NEW ROW");
            return row.stream()
                    .map(col -> {
                        counter.getAndIncrement();
                        if( String.valueOf(col).matches("^[0-9E\\.\\-]+$")  ) {
                            double number = Double.parseDouble( String.valueOf(col));



                            String string_number;

                            Long count = columnIndexes.stream()
                                .filter(map -> map.get("index") == (counter.get()-1)).count();
//                            System.out.println("COUNT -> " + count);
                            if( count == 1 ){
                                string_number = NumberUtil.toMoneyWithoutDecimalPoint( Math.abs(number) );
                            } else {
                                string_number = NumberUtil.money( Math.abs(number) );
                            }


                            if( NumberUtil.isMoneyAndHasPoint(string_number)  ) {
                                string_number = string_number.substring(0, string_number.length()-2);

                            }

                            if( number < 0) {
                                return "("+string_number+")";
                            } else {
                                return string_number;
                            }
                        }



                        return col;
                    })
                    .collect(Collectors.toList());
    }


    private boolean isDecimal( Object number){
        Objects.requireNonNull(number);
        return (Double.parseDouble(number.toString()) % 1 != 0);
    }


    public static String addDecimalPoint(Number number, int minimumFractionDigit, int maximumFractionDigit) {
        DecimalFormat df2 = new DecimalFormat("###.#");
        df2.setMinimumFractionDigits(minimumFractionDigit);
        df2.setMaximumFractionDigits(maximumFractionDigit);
        return df2.format(number.doubleValue());
    }

    public static String money(double number) {
        return NumberUtil.money( number, 1, 1 );
    }

    public static String money(double number, int minimumFractionDigits, int maximumFractionDigits) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        nf.setMaximumFractionDigits(maximumFractionDigits);
        nf.setMinimumFractionDigits(minimumFractionDigits);

        return nf.format( number );
    }

    public static String toMoneyWithoutDecimalPoint(Double num){
        DecimalFormat df2 = new DecimalFormat("#,###");
        return df2.format(num);
    }

    public static double toNumber(String money) {
        if( money.equalsIgnoreCase("null") || money == null ) {
            return 0.00;
        }
        return Double.parseDouble(  money.replaceAll("\\,", "") );
    }

    public static boolean hasDecimal(Number number) {
        return (number.doubleValue() % 1 != 0);
    }


    public static boolean isMoneyAndHasPoint(String number){
        Objects.requireNonNull(number);
        if( number.contains(",") && number.contains(".")  ){
            return true;
        }
        return false;
    }


    public static int toInteger(Number number){
        Objects.requireNonNull(number);
        return number.intValue();
    }

    public static int toInteger(Object number){
        return NumberUtil.toInteger( Integer.parseInt(String.valueOf(number)));
    }

    public static double toDouble(Number number){
        Objects.requireNonNull(number);
        return number.doubleValue();
    }

    public static double toDouble(Object number){
        return NumberUtil.toDouble( Double.parseDouble(String.valueOf(number)));
    }


    public static boolean isNumber(String number){
        if( number instanceof String){
            return number.matches("[0-9\\.\\-E]+");
        } else {
            return false;
        }
    }

}
