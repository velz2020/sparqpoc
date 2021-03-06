package org.sparqpoc.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;
    static { System.out.println("***JwtAuthenticationTokenFilter Called***");}
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader(this.tokenHeader);
        String method = request.getMethod();
        String tempToken = request.getHeader(this.tokenHeader);
        // authToken.startsWith("Bearer ")
        // String authToken = header.substring(7);
        
        System.out.println("***JwtAuthenticationTokenFilter - doFilterInternal Called***");
        System.out.println("***JwtAuthenticationTokenFilter - current Method"+method);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if(tempToken != null)
        {
        	 logger.info("IF tempToken print" + tempToken);
        }
        else{ 
        	
        	logger.info("ELSE tempToken print" + tempToken); 
        }

        logger.info("checking authentication for user " + username);
        logger.info("checking authentication for method " + method);
        
//        if ("OPTIONS".equalsIgnoreCase(method)) {
//        	response.setHeader("Access-Control-Allow-Origin", "*");
//	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//	        response.setHeader("Access-Control-Max-Age", "3600");
//	        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization");
//         	response.setStatus(HttpServletResponse.SC_OK);
//     }else{
        
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // It is not compelling necessary to load the use details from the database. You could also store the information
            // in the token and read it from it. It's up to you ;)
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
            // the database compellingly. Again it's up to you ;)
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        

     // }
    chain.doFilter(request, response);
       
    }
}