package com.myallutilities.utilities.utilities;

import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public final class Validator<T> {

    private T value;
    private String key;
    private Set<ValidatorPayload> validatorPayloads = new HashSet<>();

    public Validator(String key, final T value){
        this.value = value;
        this.key = key;
    }

    public static <T> Validator<T> reject(final String key, final T value){
            return new Validator<>(key, value);
    }
    public Validator<T> andReject(final String key, final T value){
        this.value = value;
        this.key = key;
        return this;
    }

    public Validator<T> ifNull(String message){
        if(  ValidatorUtils.isNull(value) ){
            validatorPayloads.add(new ValidatorPayload(message, key));
        }
        return this;
    }

    public Validator<T> ifEmpty(String message){

        if( !ValidatorUtils.isNull(value) ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }

    public Validator<T> ifMaxLength(int length, String message){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > length ) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }
    public Validator<T> ifMinLength(int length, String message){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (strValue.length() < length) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }
    public Validator<T> ifMinStripLength(int length, String stripRegexPattern, String message){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (strValue.length() < length) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }
    public Validator<T> ifMaxStripLength(int length, String stripRegexPattern,  String message){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > length ) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }

    public Validator<T> ifPattern(String regexPattern, String message){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (!strValue.matches(regexPattern)) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }



    private boolean isValueNull(){
        return ValidatorUtils.isNull(this.value);
    }


//    public Validator<T> pipe(Predicate<T>... predicates){
//
//        Stream.of(predicates)
//                .forEach(predicate -> {
//                    if( predicate.test(value) ){
//                        validatorPayloads.add(new ValidatorPayload(message, key));
//                    }
//                });
//
//    }


    public Optional<Set<ValidatorPayload>> validate(){
        if( this.validatorPayloads.size() == 0 ){
            return Optional.empty();
        } else {
            return Optional.of(this.validatorPayloads);
        }
    }


//    public Validator<T> empty(Predicate<T> test){
//        test.test(value);
//        return this;
//    }

    public void validate(final Consumer<Set<ValidatorPayload>> consumer){
        consumer.accept(this.validatorPayloads);
    }

//    public static <T> Validator<T> rejectIf(final Supplier<T> supplier){
//        return new Validator<>(supplier.get());
//    }


    public static ValidatorPayload payload(String code, String message){
        return new ValidatorPayload(message, code);
    }

    public static class ValidatorPayload {
        private String message;
        private String key;



        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return key;
        }

        public void setCode(String code) {
            this.key = code;
        }

        public ValidatorPayload() {
        }

        public ValidatorPayload(String message, String key) {
            this.message = message;
            this.key = key;
        }

        @Override
        public String toString() {
            return "ValidatorPayload{" +
                    "message='" + message + '\'' +
                    ", key='" + key + '\'' +
                    '}';
        }
    }
}
