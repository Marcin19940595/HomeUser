package com.example.HomeUser;

import com.example.HomeUser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;

@SpringBootApplication
public class HomeUserApplication{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(HomeUserApplication.class, args);

	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JWTFilter());
		filterRegistrationBean.addUrlPatterns("/questions","/question/{id}","/newQuestion","/question/{id}","/drawquestions","/score","/score/{id}","/users","/user/{id}","/newUser","/user/{id}");
		//filterRegistrationBean.setUrlPatterns(Collections.singleton("/users"));
		return filterRegistrationBean;
	}
}