package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoStreamVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStreamVideoApplication.class, args);
		Student student=new Student(1001,"Ram");
		System.out.println("hello");
		Student student1=new Student(100,"Ram");
		System.out.println(student1.getId());
	}

}
