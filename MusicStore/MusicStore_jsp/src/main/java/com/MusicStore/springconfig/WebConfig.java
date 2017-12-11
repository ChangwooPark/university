package com.MusicStore.springconfig;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.MusicStore.Controller")
public class WebConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver resolver =

		new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");

		resolver.setSuffix(".do");

		return resolver;

	}

}
