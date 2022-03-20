package io.mzlnk.identitybroker.server.application.config;

import io.mzlnk.identitybroker.server.application.converter.AuthCallbackContextConverter;
import io.mzlnk.identitybroker.server.application.logging.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile("!dev")
@Configuration
@RequiredArgsConstructor
public class WebMvcDefaultConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new AuthCallbackContextConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }

}
