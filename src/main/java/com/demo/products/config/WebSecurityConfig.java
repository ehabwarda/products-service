package com.demo.products.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static String[] AUTH_WHITE_LIST = new String[]{"/swagger-ui.html"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers()
                .disable()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITE_LIST)
                .permitAll();
    }

}
