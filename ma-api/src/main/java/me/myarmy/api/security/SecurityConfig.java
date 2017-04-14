package me.myarmy.api.security;

import me.myarmy.api.controller.filter.CORSFilter;
import me.myarmy.api.controller.filter.StatelessAuthenticationFilter;
import me.myarmy.api.controller.filter.StatelessLoginFilter;
import me.myarmy.api.security.handler.SecurityFailureHandler;
import me.myarmy.api.security.handler.SecurityLogoutSuccessHandler;
import me.myarmy.api.security.handler.SecuritySuccessHandler;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

/**
 * Created by Manki Kim on 2017-04-03.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SecuritySuccessHandler securitySuccessHandler;
    @Autowired
    private SecurityFailureHandler securityFailureHandler;
    @Autowired
    private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;
    @Autowired
    private UserService userService;

    @Autowired
    private CORSFilter corsFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Filters will not get executed for the resources
        web.ignoring().antMatchers("/", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/*"
                , "/configuration/**", "/swagger-ui/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
                , "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.gif", "/**/*.svg", "/**/*.ttf", "/**/*.woff");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //h2 database console
        http.headers().frameOptions().disable();

        http.exceptionHandling()
                .and().anonymous()
                .and().servletApi()
                .and().headers().cacheControl();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/category/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/console/**").permitAll();
        http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
        http.addFilterBefore(
                new StatelessLoginFilter("/api/v1/login", this.tokenAuthenticationService,userService,authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(
                new StatelessAuthenticationFilter(this.tokenAuthenticationService),
                UsernamePasswordAuthenticationFilter.class);

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ;

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
