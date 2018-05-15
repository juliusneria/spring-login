package com.sample.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@SpringBootApplication
public class SampleloginApplication {

	/*@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid User user){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SampleloginApplication.class, args);
	}
}
