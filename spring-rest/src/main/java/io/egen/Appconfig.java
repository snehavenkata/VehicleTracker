package io.egen;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class Appconfig extends WebMvcConfigurerAdapter{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**/*")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);

    }
}

