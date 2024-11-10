package com.legalunicorn.logger.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**");
        /*
        - returnes a cors registration object, which we can use for additional configuration

        registry has other methods
        - allowedMethods
        - allowedHeaders
        - exposedHeader
        - maxAge
        - allowCredentials
        https://www.baeldung.com/spring-cors

         */


    }
}
/*
If we use CORS with spring security

we must configure extra too
 */
