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

//		Set<String> x = n

		String name = "Heheh";


		Validator
				.reject("NAME","RIMURU TEMPEST")
				.ifPattern("^[a-zA-Z\\s]+$","NAME MUST NOT HAVE CONTAINS SPECIAL CHARACTERS")
				.ifMinLength(2, "MUST HAVE ATLEAST 2 ALPA CHARACTERS")
				.ifMaxLength(100, "TAE")
				.ifNull("SHOULD NOT BE NULL")
				.ifEmpty("SHOULD NOT BE EMPTY")
				.andReject("NAME",null)
				.ifPattern("^[a-zA-Z\\s]+$","NAME MUST NOT HAVE CONTAINS SPECIAL CHARACTERS")
				.ifMinLength(2, "MUST HAVE ATLEAST 2 ALPA CHARACTERS")
				.ifMaxLength(100, "TAE")
				.ifNull("SHOULD NOT BE NULL")
				.ifEmpty("SHOULD NOT BE EMPTY")
				.validate(x -> {
					System.out.println(x);
				});

//		Validator.of(test)
//				.
//		Validator.<List<? extends CharSequence>>of(() -> Arrays.asList("a","b","c"));
//		Validator.<String>reject(() -> test);

//		Some.<List<? extends CharSequence>>of(() -> Arrays.asList("a","b","c"))
//				.peek(System.out::println);
//		Some.<List<? extends CharSequence>>of(() -> Arrays.asList("a","b","c"))
//				.test(x -> {
//					x.
//				})
//
////		some.peek(x -> {{
////
////		}});
//
//		System.out.println(some.get());

//		String s = IntStream.range(1,2)
//				.mapToObj(x -> "#")
//				.collect(Collectors.joining());
//
//		System.out.println(s);



		int x = 5;
//		Validator.rejectIf("name")
//				.empty(x -> x.)

//		Stream.of(x)
//				.fil
//				.filter(x -> x.length() == 0);
//		Stream.of(name)
//				.it
//
//		Validator
//				.rejectIf(name)
//				.



	}



}

