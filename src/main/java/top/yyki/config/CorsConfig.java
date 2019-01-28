package top.yyki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.yyki.interceptor.AuthIntercepter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthIntercepter authIntercepter;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("*").allowCredentials(true).
                allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS").
                allowedHeaders("*").
                exposedHeaders("Authorization").
                maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercepter).addPathPatterns("/**").excludePathPatterns("/verify");
    }

}

