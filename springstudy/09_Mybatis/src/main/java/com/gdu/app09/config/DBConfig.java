package com.gdu.app09.config;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;


/*
	@PropertySource
	안녕. 난 프로퍼티 파일을 참조할 수 있는 애너테이션이야.
*/
@PropertySource(value = {"mybatis/config/db.properties"})

@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
public class DBConfig {

	// db.properties 파일을 읽어서 변수에 저장하기
	// ${프로퍼티명}
	@Value(value = "${driver}")
	private String driver;
	
	@Value(value="${url}")
	private String url;
	
	@Value(value="${username}")
	private String username;
	
	@Value(value="${password}")
	private String password;
	
	// 트랜잭션 처리를 위한 TransactionManager를 Bean으로 등록한다.
	
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
