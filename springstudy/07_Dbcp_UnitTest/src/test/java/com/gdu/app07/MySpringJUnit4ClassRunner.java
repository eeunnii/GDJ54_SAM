package com.gdu.app07;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.junit.runners.model.InitializationError;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
	연습으로 해 보지만 실무에서 쓰지는 말자.
*/

// SpringJUnit4ClassRunner를 대신하는 클래스
public class MySpringJUnit4ClassRunner extends SpringJUnit4ClassRunner {

	/*
		DBCP 설정은 톰캣이 필요하다.(context.xml에 설정 값이 저장되어 있음)
		단위 테스트는 톰캣 없이 수행되기 때문에
		DBCP 설정된 프로젝트는 단위 테스트가 안 된다.
		context.xml에 작성된 DB 접속 정보를 다른 방식으로 읽어 들일 수 있도록
		SpringJUnit4ClassRunner를 상속 받아서 커스터마이징한다.
	*/
	
	public MySpringJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		jndi();
	}

	private void jndi() {

		// JNDI 방식으로 "java:comp/env/jdbc/oracle11g" 이름의 Resource를 호출하면,
		// 톰캣이 확인하는 context.xml을 참조하는 대신
		// 여기서 만든 BasicDataSource를 사용하시오.
		
		try {
			
			// SimpleNamingContextBuilder는 현재 사용을 하지 않는 것이 좋다.
			SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
			builder.activate();
			
			BasicDataSource dataSource = new BasicDataSource();  // tomcat-dbcp 디펜던시가 필요하다. (pom.xml 참고)
			dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("SCOTT");
			dataSource.setPassword("TIGER");
			
			JndiTemplate jndiTemplate = new JndiTemplate();
			jndiTemplate.bind("java:comp/env/jdbc/oracle11g", dataSource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
