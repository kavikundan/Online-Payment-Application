package com.moneytap.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class BankApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}



	@Bean
	public Docket customDocket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(
						Arrays.asList(new ParameterBuilder()
								.name("Authorization")
								.description("Description of header")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(true)
								.allowEmptyValue(true)
								.defaultValue("Bearer")
								.build())); //some customization goes here
	}

}
