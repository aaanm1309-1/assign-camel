package com.adriano.assignmentpartone;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssignmentpartoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentpartoneApplication.class, args);
	}

//	Comment Bellow if you want to use Spring Rest or Will Use Apache Rest
	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(),  "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}
}
