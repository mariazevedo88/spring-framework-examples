package io.github.mariazevedo88.springframeworkexamples;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import io.github.mariazevedo88.springframeworkexamples.model.Profile;

@Component
public class SpringFrameworkExamples2Application {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringFrameworkExamples2Application.class);
	
	public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext();
        context.scan("io.github.mariazevedo88");
        context.refresh();

        var bean = context.getBean(SpringFrameworkExamples2Application.class);
        bean.run();
        
        var beanProfile = context.getBean(Profile.class);
        logger.info("Departments: " + String.valueOf(beanProfile.getNumberOfDepartments()));
        logger.info("Employee level: " + beanProfile.getProfileLevel());

        context.close();
    }
	
	public void run() {
        logger.info("Current date: {}", LocalDateTime.now());
    }

}
