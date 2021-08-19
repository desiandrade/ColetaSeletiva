package com.example.coletaseletiva.config;


import com.example.coletaseletiva.service.AutenticacaoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AutenticacaoService autenticacaoService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //Adicionando uma exceção para um endpoint específico
                //.antMatchers(HttpMethod.GET, "/descartes/pesquisaLivreDoColetor").permitAll()
                // exceção para tudo a partir de um endpoint
                //.antMatchers(HttpMethod.GET, "/material/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable()
                 .httpBasic();





    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //EM MEMORIA
//            auth
//                    .inMemoryAuthentication()
//                    .passwordEncoder(codificadorPassword())
//                    .withUser("user")
//                    .password(codificadorPassword().encode("123"))
//                    .roles("USER");


        auth.userDetailsService(autenticacaoService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public PasswordEncoder codificadorPassword() {
        return new BCryptPasswordEncoder();
    }




}

