package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		/*	Run Application From here (Run-as Java Application) 
		 * 	The Application will run on   =     http://localhost:3000/products
		 * 	If you want to change the port, then change server port from 
		 * 	src/main/resources/application.properties.
		 * */
		SpringApplication.run(Application.class, args);
	}
}
