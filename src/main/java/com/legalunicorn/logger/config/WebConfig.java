package com.legalunicorn.logger.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
//When I added EnableWebMvc -> error formatting data
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){

    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
//                .allowedOrigins("https://springlogger-production.up.railway.app","http://localhost:5173")
                .allowedMethods("GET","POST","PUT","DELETE","PATCH");

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
