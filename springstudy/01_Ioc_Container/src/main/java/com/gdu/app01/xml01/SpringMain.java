package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		// 기존 개발자
		// 개발자가 Bean을 만들었다.
		// Calculator calculator = new Calculator();

		// 새로운 프레임워크
		// 프레임워크가 만든 Bean을 가져다 쓴다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:xml01/appCtx.xml");
		Calculator calculator = ctx.getBean("calculator", Calculator.class);
		calculator.add(5, 2);
		calculator.sub(5, 2);
		calculator.mul(5, 2);
		calculator.div(5, 2);
		
		ctx.close();  // 생략 가능
		
	}

}
