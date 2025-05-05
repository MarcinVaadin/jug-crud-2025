package com.example.application.security;

//import com.example.application.ui.views.LoginView;
//import com.vaadin.flow.spring.security.VaadinWebSecurity;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration extends VaadinWebSecurity {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth.requestMatchers(new
//                AntPathRequestMatcher("/public/**")).permitAll());
//        super.configure(http);
//        setLoginView(http, LoginView.class);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    /**
//     * Demo UserDetailsManager which only provides two hardcoded in memory users
//     * and
//     * their roles. NOTE: This shouldn't be used in real world applications.
//     */
//    @Bean
//    public UserDetailsManager userDetailsService() {
//        UserDetails user =
//                User.withUsername("user").password("{noop}user").roles("USER").build();
//        UserDetails admin =
//                User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//}
