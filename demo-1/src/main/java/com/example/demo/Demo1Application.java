package com.example.demo;

import com.example.demo.controller.transactionController;
import com.example.demo.service.transactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
	private com.example.demo.service.transactionService transactionService;
	private com.example.demo.controller.transactionController transactionController;
	final  static Logger log = LogManager.getLogger(Demo1Application.class);
	public static void main(String[] args) {

		SpringApplication.run(Demo1Application.class, args);
		log.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("in Command Line runner");
	}

	/*private void hello() {
		String[] arr={"15-11-2020","14-11-2021"};
		System.out.println(Arrays.toString(arr));
		//transactionController.check();
	}*/
}