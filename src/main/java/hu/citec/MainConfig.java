package hu.citec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("hu.citec")
@PropertySource({"classpath:application.properties", "classpath:application-${spring.profiles.active}.properties"})
public class MainConfig {
	
	@Bean
	public JdbcTemplate jdbcTemplate(
		@Value("${database_url}") String url,
		@Value("${user}") String user,
		@Value("${password}") String password) {
		return new JdbcTemplate(dataSource(url, user, password));
	}
	
	private DataSource dataSource(String url, String user, String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.err.println("url: " + url + "\n pass: " + password + "\n user: " + user);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dataSource;
	}

}
