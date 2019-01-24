package com.myallutilities.utilities;

import com.myallutilities.utilities.utilities.Validator;
import com.myallutilities.utilities.utilities.ValidatorTest;
import com.myallutilities.utilities.utilities.ValidatorUtils;
import com.myallutilities.utilities.utilities.ValidatorV2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Predicate;

@SpringBootApplication
public class UtilitiesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UtilitiesApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Student student = new Student(1000L, "SOME STUDENT");

		Map<String, List<Predicate<String>>> validators = new HashMap<>();

		validators.put("name", Arrays.asList(ValidatorTest.required(), ValidatorTest.required()) );

		ValidatorV2.validate(student, validators);




//		Validator.validate(myClass,
//				"lastName"
//				)

//		Validator.reject(name, "name")
//				.

//		String lastName = "";
//		String firstName = null;
//
//		String name = "Heheh";
//		String mobile = null;
//
//
//		String password1 = "chick2";
//		String password2 = "chick";
//
//		Validator
//				.reject("password",password1)
//				.ifNullOrEmpty()
//				.ifNotEqualWith(password2, "NOT EQUAL")
//				.validate(System.out::println);

//		String mail = "akame1v33@@gmail.com";
//		System.out.println(
//				Validator.reject("mail", mail)
//						.ifNull("null")
//						.ifEmpty("empty")
//						.ifNotMail("not mail")
//						.ifNotMobile("HEHEHE")
//						.test(v -> {
//							return true;
//						}, "custom")
//						.validate()
//		);


//		Validator.reject("mobile", mobile)
//				.ifEmpty("mobile must not be empty")
//				.ifNull(() -> "mobile is required")
//				.ifNotMobile("Mobile format should be 11 digits numbers")
//				.validate().isPresent();
//
//		Validator.reject("lastName", lastName)
//				.ifNull(() -> "NULL VALUE NOT ALLOWED")
//				.ifEmpty(() -> "EMPTY VALUE NOT ALLOWED")
//				.test( (value) -> true, () -> "CUSTOMIZE SHITS")
//				.validate();



	}



}

