package dev.yestoday.yestoday.server.config;

import dev.yestoday.yestoday.web.interceptor.CustomInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())
                .addPathPatterns("/api/todo/test")
                .addPathPatterns("/**/**/**")
                .addPathPatterns("/**/**/*")
                .addPathPatterns("/*/*/*")
                .addPathPatterns("/**")
                .addPathPatterns("/*")
                .addPathPatterns("/api/**")
                .addPathPatterns("/api/*");
    }
}
