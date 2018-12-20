package com.myallutilities.utilities.utilities;



import com.myallutilities.utilities.constant.Pattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public final class ValidatorUtils {

private ValidatorUtils() {}

    public static boolean isEmptyOrNull(final String text) {
        if( text == null ) {
            return true;
         }
         if( text.isEmpty() ) {
             return true;
         }
         return false;
    }

    public static boolean isEmpty(final Object text) {
        String strText = (String)text;
        if( strText.isEmpty() ) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Object object) {
         return (object == null) ? true : false;
    }

        public static boolean isValidDate(String dateToValidate, String dateFormat){
            if(dateToValidate == null){
                return false;
            }
            if( !dateToValidate.matches(Pattern.CUSTOM_DATE_FORMAT) ) {
                return false;
            }
            dateToValidate = dateToValidate.trim();
            //check if all digit

            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            sdf.setLenient(false);

            try {
                sdf.parse(dateToValidate);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public static boolean isPhone(String phone) {

            if( !ValidatorUtils.isEmptyOrNull(phone) ) {
                return false;
            }
            if( !phone.matches( Pattern.PHONE ) ) {
                return false;
            }
            return true;
        }
        public static boolean isMobile(String mobile) {

            if( !ValidatorUtils.isEmptyOrNull(mobile) ) {
                return false;
            }

            if( !mobile.matches( Pattern.MOBILE ) ) {
                return false;
            }

            return true;
        }
        public static boolean isMail(String mail) {
            if( !ValidatorUtils.isEmptyOrNull(mail) ) {
                return false;
            }
            if( !mail.matches( Pattern.MAIL ) ) {
                return false;
            }

            return true;
        }




    }
