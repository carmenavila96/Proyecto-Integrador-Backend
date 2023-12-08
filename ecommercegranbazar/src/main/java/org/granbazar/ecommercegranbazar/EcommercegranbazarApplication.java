package org.granbazar.ecommercegranbazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.generation.ecommerce.config.JwtFilter; como estoy en el granBazar ocupo el de abjo
import org.granbazar.ecommercegranbazar.config.JwtFilter;

@SpringBootApplication
public class EcommercegranbazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercegranbazarApplication.class, args);
	}//main
	
@Bean
public FilterRegistrationBean<JwtFilter> jwtFilter(){
FilterRegistrationBean<JwtFilter> registrationBean = 
						new FilterRegistrationBean<>();
    registrationBean.setFilter(new JwtFilter());
	registrationBean.addUrlPatterns("/api/productos/*");
    registrationBean.addUrlPatterns("/api/usuarios/*");
    return registrationBean;
	}//jwtFilter
	

}