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

//    public Validator<T> ifNull(){
//        if(  isValueNull()){
//            validatorPayloads.add(new ValidatorPayload("VALUE MUST NOT BE NULL", key));
//        }
//        return this;
//    }

//   @NO PARAM
    public Validator<T> ifNull(){
        if(  isValueNull()){
            validatorPayloads.add(new ValidatorPayload("VALUE MUST NOT BE NULL", key));
        }
        return this;
    }
    public Validator<T> ifEmpty(){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload("VALUE MUST NOT BE EMPTY", key));
            }
        }
        return this;
    }
    public Validator<T> ifNullOrEmpty(){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload("VALUE MUST NOT BE EMPTY OR NULL", key));
            }
        }
        return this;
    }
    public Validator<T> ifNotEqualWith(String anotherValue){
        if( !isValueNull() ){
            if( !String.valueOf(value).equalsIgnoreCase(anotherValue) ){
                validatorPayloads.add(new ValidatorPayload("VALUE 1 AND VALUE 2 ARE NOT EQUAL", key));
            }
        }

        return this;
    }

//  @STRING
    public Validator<T> ifNotEqualWith(String anotherValue, String message){
        if( !isValueNull() ){
            if( !String.valueOf(value).equalsIgnoreCase(anotherValue) ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }

        return this;
    }
    public Validator<T> ifNotPhone(String message){
        if( !isValueNull() ){
            if( !ValidatorUtils.isPhone(String.valueOf(value)) ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }

        return this;
    }
    public Validator<T> ifNotMobile(String message){
        if( !isValueNull() ){
            if( !ValidatorUtils.isMobile(String.valueOf(value)) ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        
        return this;
    }
    public Validator<T> ifNotMail(String message){
        if( !isValueNull() ){
            if( !ValidatorUtils.isMail(String.valueOf(value))  ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }

        return this;
    }
    public Validator<T> ifNotMobile(String regexPattern, String message){
        if( !isValueNull() ){
            if( !String.valueOf(value).matches(regexPattern)    ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }

        return this;
    }
    public Validator<T> ifNotMail(String regexPattern, String message){
        if( !isValueNull() ){
            if( !String.valueOf(value).matches(regexPattern)  ){
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }

        return this;
    }
    
    public Validator<T> test(Predicate<T> predicate, String message){
        if( predicate.test(value) ){
            validatorPayloads.add(new ValidatorPayload(message, key));
        }
        return this;
    }

    public Validator<T> ifNull(String message ){
        if(  isValueNull()){
            validatorPayloads.add(new ValidatorPayload(message, key));
        }
        return this;
    }



    public Validator<T> ifEmpty(String message){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }

    public Validator<T> ifNullOrEmpty(String message){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }

    public Validator<T> ifMaxMin(int max, int min, String message){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > max || strValue.length() < min) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }

    public Validator<T> ifMaxLength(int max, String message){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > max ) {
                validatorPayloads.add(new ValidatorPayload(message, key));
            }
        }
        return this;
    }
    public Validator<T> ifMinLength(int min, String message){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (strValue.length() < min) {
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

    public Optional<Set<ValidatorPayload>> validate(){
        if( this.validatorPayloads.size() == 0 ){
            return Optional.empty();
        } else {
            return Optional.of(this.validatorPayloads);
        }
    }


    public void validate(final Consumer<Set<ValidatorPayload>> consumer){
        consumer.accept(this.validatorPayloads);
    }



    //@ SUPPLIER
    public Validator<T> ifNotPhone(Supplier<String> supplier){
        if( !isValueNull() ){
            if( !ValidatorUtils.isPhone(String.valueOf(value)) ){
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }

        return this;
    }
    public Validator<T> ifNotMobile(Supplier<String> supplier){
        if( !isValueNull() ){
            if( !ValidatorUtils.isMobile(String.valueOf(value)) ){
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }

        return this;
    }
    public Validator<T> ifNotEqual(String anotherValue, Supplier<String> supplier){
        if( !isValueNull() ){
            if( !String.valueOf(value).equalsIgnoreCase(anotherValue) ){
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }

        return this;
    }
    public Validator<T> ifMaxMin(int max, int min, Supplier<String> supplier){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > max || strValue.length() < min) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }


    public Validator<T> ifNullOrEmpty(Supplier<String> supplier){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }

    public Validator<T> ifPattern(String regexPattern, Supplier<String> supplier){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (!strValue.matches(regexPattern)) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }

    public Validator<T> test(Predicate<T> predicate, Supplier<String> supplier){
        if( predicate.test(value) ){
            validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
        }
        return this;
    }

    public Validator<T> ifNull(Supplier<String> supplier ){
        if(  ValidatorUtils.isNull(value) ){
            validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
        }
        return this;
    }

    public Validator<T> ifEmpty(Supplier<String> supplier){
        if( !isValueNull() ) {
            if (ValidatorUtils.isEmpty(value)) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }

    public Validator<T> ifMaxLength(int length, Supplier<String> supplier){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > length ) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }
    public Validator<T> ifMinLength(int length, Supplier<String> supplier){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (strValue.length() < length) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }
    public Validator<T> ifMinStripLength(int length, String stripRegexPattern, Supplier<String> supplier){
        if( !this.isValueNull() ) {
            String strValue = (String) value;
            if (strValue.length() < length) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
    }
    public Validator<T> ifMaxStripLength(int length, String stripRegexPattern,  Supplier<String> supplier){
        if( !this.isValueNull() ){
            String strValue = (String) key;
            if( strValue.length() > length ) {
                validatorPayloads.add(new ValidatorPayload(supplier.get(), key));
            }
        }
        return this;
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
