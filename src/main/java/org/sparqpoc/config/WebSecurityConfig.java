package org.sparqpoc.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sparqpoc.security.JwtAuthenticationEntryPoint;
import org.sparqpoc.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }
    static{System.out.println("***Webconfig Called***");}
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	System.out.println("***Webconfig - configure Called***");
        httpSecurity
        
        		.cors().and()
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // allow anonymous resource requests 
                .antMatchers(
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers(
                        "/common/**"
                 ).permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated();

        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
    
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//       web.ignoring().antMatchers(HttpMethod.OPTIONS);
//    }
//	public void addCorsMappings(CorsRegistry registry) {
// 
//		registry.addMapping("/**")
//				.allowedOrigins("http://localhost:1990")
//				.allowedMethods("POST", "GET", "PUT", "DELETE","OPTIONS")
//				.allowedHeaders("Content-Type")
//				.exposedHeaders("header-1", "header-2")
//				.allowCredentials(true)
//				.maxAge(6000);
// 
//	}
    
    
   // @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public CorsFilter corsFilter() {
    	System.out.println("***CorsFilter Called***");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
//    @Component
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public class SimpleCorsFilter implements Filter {
//
//        public SimpleCorsFilter() {
//        }
//
//        @Override
//        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//            HttpServletResponse response = (HttpServletResponse) res;
//            HttpServletRequest request = (HttpServletRequest) req;
////            response.setHeader("Access-Control-Allow-Origin", "*");
////            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
////            response.setHeader("Access-Control-Max-Age", "3600");
////            response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization");
//
//            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//                response.setStatus(HttpServletResponse.SC_OK);
//            } else {
//                chain.doFilter(req, res);
//            }
//        }
//
//        @Override
//        public void init(FilterConfig filterConfig) {
//        }
//
//        @Override
//        public void destroy() {
//        }
//    }
}