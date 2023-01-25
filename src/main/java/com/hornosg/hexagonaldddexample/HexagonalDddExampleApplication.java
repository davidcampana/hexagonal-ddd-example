package com.hornosg.hexagonaldddexample;

import com.hornosg.hexagonaldddexample.shared.infrastructure.SpringBootControllerExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringBootControllerExceptionHandler.class)
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class HexagonalDddExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalDddExampleApplication.class, args);
	}

}
