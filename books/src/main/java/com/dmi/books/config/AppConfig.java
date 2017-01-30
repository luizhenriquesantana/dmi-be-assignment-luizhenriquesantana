package com.dmi.books.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Class that configures the application.
 * @author luizhenriquesantana
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dmi.books")
public class AppConfig {
	
}
