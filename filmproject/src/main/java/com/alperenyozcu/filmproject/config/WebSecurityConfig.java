package com.alperenyozcu.filmproject.config;


import com.alperenyozcu.filmproject.Enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .hasAuthority(UserRole.USER.toString())
                .antMatchers("/admin/**")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/AddFilms")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/AddActors")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/Films")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/AddLang")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/AddAct")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/SaveLang")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/Add")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film//Detay/*")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/Update")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/Film/Search")
                .hasAuthority(UserRole.ADMIN.toString())
                .antMatchers("/")
                .hasAnyAuthority(UserRole.ADMIN.toString(), UserRole.USER.toString())
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}











