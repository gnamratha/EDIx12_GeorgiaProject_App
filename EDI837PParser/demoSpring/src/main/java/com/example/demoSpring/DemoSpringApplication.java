package com.example.demoSpring;

import com.example.demoSpring.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
// @RestController
// Rest Controller makes this class to serve REST endpoints
public class DemoSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringApplication.class, args);
	}
	//Our rest endpoint
	//@GetMapping //This annotation makes this method as an endpoint
//	public List<Student> hello() {
//		return List.of(
//				new Student(
//						1L,
//						"Mary",
//						"mary@gmail.com",
//						LocalDate.of(2000, Month.JANUARY, 5),
//						21
//				)
//		);
// }
}
