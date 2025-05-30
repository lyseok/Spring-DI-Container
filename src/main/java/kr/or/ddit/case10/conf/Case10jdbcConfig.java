package kr.or.ddit.case10.conf;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 *  javax.sql.DataSource
 *  JdbcTemplate
 *  NamedParameterJdbcTemplate
 */
@Slf4j
@Configuration
public class Case10jdbcConfig {
	@Bean("infoProps")
	public PropertiesFactoryBean dbInfoProp(
		@Value("classpath:kr/or/ddit/db/DBInfo.properties") Resource location	
	) throws IOException {
		PropertiesFactoryBean factoryBean = 
				new PropertiesFactoryBean();
//		log.info("location : {}", location);
		factoryBean.setLocation(location);
//		factoryBean.afterPropertiesSet();
		return factoryBean;
//		return factoryBean.getObject();
	}
	
	@Bean // dataSource 라는 아이디로 빈을 등록함.
	public DataSource dataSource(
		@Value("#{infoProps['maindb.driverClassName']}") String driverClassName	
		, @Value("#{infoProps['maindb.url']}") String url	
		, @Value("#{infoProps['maindb.username']}") String username	
		, @Value("#{infoProps['maindb.password']}") String password	
		, @Value("#{infoProps['maindb.autoCommit']}") boolean autoCommit	
		, @Value("#{infoProps['maindb.minimumIdle']}") int minimumIdle	
		, @Value("#{infoProps['maindb.maximumPoolSize']}") int maximumPoolSize	
		, @Value("#{infoProps['maindb.connectionTimeout']}") long connectionTimeout	
	) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setAutoCommit(autoCommit);
		ds.setMinimumIdle(minimumIdle); // 초기에 몇개의 connection을 만들 것인가
		ds.setMaximumPoolSize(maximumPoolSize); // 최대 몇개의 connection을 만들 것인가
		ds.setConnectionTimeout(connectionTimeout); // connection이 모두 사용중이면 최대 몇밀리초만큼 대기시킬것인가
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(
		DataSource dataSource
	) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate npjt(
		DataSource dataSource
	) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
