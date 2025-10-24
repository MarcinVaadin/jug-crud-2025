package com.example.application.security;
// TODO: Uncomment when enabling security
//import com.example.application.security.ui.LoginView;
//import com.vaadin.flow.spring.security.VaadinAwareSecurityContextHolderStrategyConfiguration;
//import com.vaadin.flow.spring.security.VaadinSecurityConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Import(VaadinAwareSecurityContextHolderStrategyConfiguration.class)
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.with(VaadinSecurityConfigurer.vaadin(), configurer -> configurer.loginView(LoginView.class))
//                .build();
//    }
//
//    /**
//     * Demo UserDetailsManager which only provides two hardcoded in memory users and
//     * their roles. NOTE: This shouldn't be used in real world applications.
//     */
//    @Bean
//    public UserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("user").password("{noop}user").roles("USER").build();
//        UserDetails admin = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//}
