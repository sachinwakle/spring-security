package io.sachin.security.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * 1. withDefaultSchema
     */

    /*
     * @Override protected void configure(AuthenticationManagerBuilder auth) throws
     * Exception {
     * auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
     * .withUser(User.withUsername("user").password("pass").roles("USER"))
     * .withUser(User.withUsername("admin").password("pass").roles("ADMIN")); }
     */

    /**
     * 2. Manual creation of schema
     */

    /*
     * @Override protected void configure(AuthenticationManagerBuilder auth) throws
     * Exception { auth.jdbcAuthentication().dataSource(dataSource); }
     */

    /**
     * 3. With different schema
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username = ?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/").permitAll().and().formLogin();
    }

}
