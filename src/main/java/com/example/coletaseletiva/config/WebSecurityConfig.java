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
                .antMatchers("/perfis").hasAuthority("ADMIN")
                .antMatchers("/perfis/*").hasAuthority("ADMIN")
                .antMatchers("/usuarios").hasAuthority("ADMIN")
                .antMatchers("/usuarios/*").hasAuthority("ADMIN")
                .antMatchers("/material").hasAuthority("ADMIN")
                .antMatchers("/material/*").hasAuthority("ADMIN")
                .antMatchers("/telefoneDescartante").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/telefoneDescartante/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/telefoneColetor").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/telefoneColetor/*").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/emailDescartante").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/emailDescartante/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/emailColetor").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/emailColetor/*").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/enderecoDescartante").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/enderecoDescartante/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/enderecoColetor").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/enderecoColetor/*").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/descartantes").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/descartantes/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers("/coletores").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers("/coletores/*").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers(HttpMethod.GET, "/descartes").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/descartes/descarteEndereco/*").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/descartes/pesquisaLivreDoColetor").hasAnyAuthority("ADMIN", "COLETOR")
                .antMatchers(HttpMethod.GET, "/descartes/pesquisaDoDescartante/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers(HttpMethod.GET, "/descartes/pesquisaDoDescartante").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers(HttpMethod.DELETE, "/descartes/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers(HttpMethod.POST, "/descartes").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers(HttpMethod.PUT, "/descartes/descartante/*").hasAnyAuthority("ADMIN", "DESCARTANTE")
                .antMatchers(HttpMethod.PUT, "/descartes/coletor/*").hasAnyAuthority("ADMIN", "COLETOR")
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


        auth.userDetailsService(autenticacaoService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public PasswordEncoder codificadorPassword() {
        return new BCryptPasswordEncoder();
    }




}

