package io.mzlnk.fluqxverse.authn.application.security;

import io.mzlnk.fluqxverse.springboot.authsecurity.authn.AuthNService;
import io.mzlnk.fluqxverse.springboot.authsecurity.authz.AuthZService;
import io.mzlnk.fluqxverse.springboot.authsecurity.credentials.TokenReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Primary
@Profile("dev")
@Configuration
@EnableWebSecurity
public class SecurityDevConfigurer extends SecurityDefaultConfigurer {

    public SecurityDevConfigurer(AuthenticationFailureHandler authenticationFailureHandler,
                                 AuthenticationEntryPoint authenticationEntryPoint,
                                 AccessDeniedHandler accessDeniedHandler,
                                 TokenReader tokenReader,
                                 AuthNService authNService,
                                 AuthZService authZService) {

        super(authenticationFailureHandler, authenticationEntryPoint, accessDeniedHandler, tokenReader, authNService, authZService);
    }

    @Override
    protected void configureInternal(HttpSecurity http) throws Exception {
        super.configureInternal(http);

        http.formLogin().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .cors().disable();
    }

}