package com.svss.app.svss.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class GlobalCorsConfig  implements WebMvcConfigurer{
    private static final Logger logger = LoggerFactory.getLogger(GlobalCorsConfig.class);
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("CORS Config");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
