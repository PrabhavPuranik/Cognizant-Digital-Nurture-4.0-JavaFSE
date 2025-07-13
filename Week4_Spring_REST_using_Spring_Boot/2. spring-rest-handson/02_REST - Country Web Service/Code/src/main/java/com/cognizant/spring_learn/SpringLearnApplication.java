package com.cognizant.spring_learn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

@SpringBootApplication
public class SpringLearnApplication {
	public static void main(String[] args) {
		System.out.println("SpringLearnApplication started");
		displayDate();
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	public static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			System.out.println("Parsed Date: " + date);
		} catch (ParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
		}
	}
}