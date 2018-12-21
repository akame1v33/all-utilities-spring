package com.myallutilities.utilities;

import com.myallutilities.utilities.utilities.Validator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class UtilitiesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UtilitiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String lastName = "";
		String firstName = null;

		String name = "Heheh";
		String mobile = null;


		Validator.reject("mobile", mobile)
				.ifEmpty("mobile must not be empty")
				.ifNull(() -> "mobile is required")
				.ifNotMobile("Mobile format should be 11 digits numbers")
				.validate().isPresent();

		Validator.reject("lastName", lastName)
				.ifNull(() -> "NULL VALUE NOT ALLOWED")
				.ifEmpty(() -> "EMPTY VALUE NOT ALLOWED")
				.test( (value) -> true, () -> "CUSTOMIZE SHITS")
				.validate();



	}



}

