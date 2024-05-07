package io.amofoe.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan("io.amofoe")
@SpringBootApplication
public class CompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompositeApplication.class, args);
	}

}
