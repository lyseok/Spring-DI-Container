package kr.or.ddit.case11.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.case10.conf.Case10jdbcConfig;

@ComponentScan(basePackages = "kr.or.ddit.case11")
@Configuration
@Import(Case10jdbcConfig.class)
public class Case11MybatisSpringConfig {
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(
		@Value("classpath:kr/or/ddit/case11/Configuration.xml") Resource configLocation
		, DataSource dataSource
		, @Value("classpath:kr/or/ddit/case11/objs/mapper/**/*.xml") Resource...mapperLocations
	) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(configLocation);
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(mapperLocations);
		return factoryBean;
	}
	
//	@Bean
//	public SqlSessionTemplate sqlSession(
//		SqlSessionFactory sessionFactory	
//	) {
//		SqlSessionTemplate template =
//				new SqlSessionTemplate(sessionFactory);
//		return template;
//	}
	
	@Bean
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer scanner = 
				new MapperScannerConfigurer();
		scanner.setBasePackage("kr.or.ddit.case11.objs.mapper");
		scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
		scanner.setAnnotationClass(Repository.class);
		return scanner;
	}
}
