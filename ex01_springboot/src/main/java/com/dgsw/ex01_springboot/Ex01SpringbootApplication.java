package com.dgsw.ex01_springboot;


import com.dgsw.ex01_springboot.components.A;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex01SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex01SpringbootApplication.class, args);
	}



	@Bean
	public A a(){
		return new A();
	}

}
