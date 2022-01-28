package com.example.SpringSecvice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("resources/images/**")
                .addResourceLocations("file:C:\\Users\\admin\\Desktop\\My_Folder\\Jaba\\SpringForum\\src\\main\\resources\\images\\");
        registry.addResourceHandler("post/resources/images/**")
                .addResourceLocations("file:C:\\Users\\admin\\Desktop\\My_Folder\\Jaba\\SpringForum\\src\\main\\resources\\images\\");
    }
}
