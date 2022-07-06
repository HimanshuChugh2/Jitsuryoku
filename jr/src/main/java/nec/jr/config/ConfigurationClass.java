package nec.jr.config;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import nec.jr.repository.JPASignUpRepository;

@Configuration
@EnableWebSecurity
@ComponentScan
public class ConfigurationClass extends WebSecurityConfigurerAdapter {
//	 @Autowired
//	    private MyUserDetailsService userService;
//	@Autowired
//	UserDetailsService userDetailsService;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception 	{
//	auth.userDetailsService(userDetailsService);
//	}

	@Autowired
	JPASignUpRepository jpasignuprepository;

	@Resource
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors().and().csrf().disable()
	        
	        
		  .logout(l -> l
	                .logoutSuccessUrl("/").permitAll()
	             )
          .authorizeRequests(a -> a
            		.antMatchers("/user-centre").hasAnyRole("USER","ADMIN")
            		.antMatchers("/admin-centre").hasAnyRole("ADMIN")
            		.antMatchers("/", "/error", "/webjars/**","/error-pages/**","/signup","/user", "/accessible","/enter-existing-password","/showit","/css/style.css","/index","/login").permitAll()
            		 
        		  )
           
 
				.formLogin().defaultSuccessUrl("/restricted").loginPage("/login").permitAll();
	}



	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/style.css", "/javascript/**", "/images/**",
				"/js/**", "/scss/**", "/sketch/**", "/vendors/**", "/css/**", "/fonts/**", "/images/**",
				"/icon/**,/upload/**,/anyfolder/**,/javascript/QuillContainer.js,/path/to/font-awesome/**");
	}

	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * 
	 * 
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	 * auth.setUserDetailsService(userService);
	 * auth.setPasswordEncoder(passwordEncoder()); return auth; }
	 * 
	 * 
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 */

}
