package br.com.fiap.lanchonete.configuracao;

import br.com.fiap.lanchonete.usecase.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class ConfiguracaoDeSeguranca {

    private final UsuarioService service;

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    public ConfiguracaoDeSeguranca(UsuarioService service) {
        this.service = service;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final var passwordEncoder = encoder();
        auth.userDetailsService(service)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    @ConditionalOnExpression("${security.enabled}")
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
                .requestMatchers(HttpMethod.POST ,"/clientes").permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    @ConditionalOnExpression("!${security.enabled}")
    public SecurityFilterChain filterChainDev(HttpSecurity http) throws Exception {
        http.csrf()
                .and()
                .cors().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll();

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
