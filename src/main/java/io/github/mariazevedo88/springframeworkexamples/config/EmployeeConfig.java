package io.github.mariazevedo88.springframeworkexamples.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import io.github.mariazevedo88.springframeworkexamples.model.Profile;

@Configuration
@ComponentScan(basePackages = "io.github.mariazevedo88")
@ComponentScan(basePackageClasses = EmployeeConfig.class)
@PropertySource("classpath:/application.properties")
@Lazy
@EnableAutoConfiguration
public class EmployeeConfig {
	
	@Bean
    @Lazy(false)
    public String level() {
        return new String();
    }
	
	@Bean
    @Lazy(false)
    public Profile profile() {
        return new Profile();
    }

}
