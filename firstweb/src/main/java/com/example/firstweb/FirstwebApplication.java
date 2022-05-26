package com.example.firstweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FirstwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstwebApplication.class, args);
	}

	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello Spring Boot World";
	}

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory(){
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setPort(19001);
//		factory.setSession(new Session());
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.xml"));
		return  factory;
	}


}
