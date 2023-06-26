package br.com.fiap.lanchonete.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguracaoDeSeguranca {

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("usuario")
                .password(bCryptPasswordEncoder.encode("usuario"))
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable().authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(HttpMethod.PUT).hasRole( "ADMIN")
                .requestMatchers(HttpMethod.DELETE).hasRole( "ADMIN")
                .requestMatchers("/categorias").permitAll()
                .requestMatchers(HttpMethod.GET ,"/produtos").permitAll()
                .requestMatchers(HttpMethod.GET ,"/produtos/**").permitAll()
                .requestMatchers(HttpMethod.POST ,"/produtos/**").hasAnyRole( "ADMIN")
                .requestMatchers("/login/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
