	package com.myallutilities.utilities.utilities;

    import com.pmti.tradestats.constant.Pattern;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;

//import java.util.regex.Pattern;

    public final class ValidatorUtil {

        private ValidatorUtil() {}

        public static boolean isEmptyOrNull(final String text) {

            if( text == null ) {
                return true;
            }
            if( text.isEmpty() ) {
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
        public static boolean min(String text, int minimum) {
            int textLength = text.length();
            if( minimum > textLength ) {
                return false;
            }
            return true;
        }
        public static boolean max(String text, int maximum) {
            int textLength = text.length();
            if( textLength > maximum) {
                return false;
            }
            return true;
        }
        public static boolean isPhone(String phone) {

            if( !ValidatorUtil.isEmptyOrNull(phone) ) {
                return false;
            }
            if( !phone.matches( Pattern.PHONE ) ) {
                return false;
            }
            return true;
        }
        public static boolean isMobile(String mobile) {

            if( !ValidatorUtil.isEmptyOrNull(mobile) ) {
                return false;
            }

            if( !mobile.matches( Pattern.MOBILE ) ) {
                return false;
            }

            return true;
        }
        public static boolean isMail(String mail) {
            if( !ValidatorUtil.isEmptyOrNull(mail) ) {
                return false;
            }
            if( !mail.matches( Pattern.MAIL ) ) {
                return false;
            }

            return true;
        }
    }
