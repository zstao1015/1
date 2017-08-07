package com.springmybatis.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmybatis.pojo.Car;
import com.springmybatis.service.CarService;

public class CatServiceTest {
	
	private CarService carService;
	
	@Test
	public void add(){
		Car car = new Car();
		car.setName("ÂêÉ¯À­µÙ");
		car.setPrice(999999d);
		car.setCreateDate(new Date());
		int count = carService.add(car);
		if (count>0) {
			System.out.println("OK");
		}else {
			System.out.println("Error");
		}
		
	}
	
	@Test
	public void find(){
		for (Car car:carService.find()) {
			System.out.println(car.getName()+" "+car.getPrice());
		}
	}
	
	
	
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		carService = ctx.getBean("carService",CarService.class);
	}

}
