package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableWebMvc
@SpringBootApplication
public class ConsommiTounsiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsommiTounsiApiApplication.class, args);
	}

}
