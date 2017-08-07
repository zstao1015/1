package com.springmybatis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmybatis.dao.CarMapper;
import com.springmybatis.pojo.Car;

/**
 * 业务逻辑层  由spring管理
 * @author Administrator
 * service 业务逻辑层,由 Spring 管理
 */
@Service("carService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CarService {
  // Spring -> Mybatis (通过注解方式注入 mapper 实例)
  @Resource(name = "carMapper")
  private CarMapper carMapper;

  // 注解事务:必须要有事务,没有则开启一个新事务;隔离级别 commited-read;回滚事务
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
          rollbackFor = Exception.class)
  	public int add(Car car){
		return carMapper.add(car);
	}
	
	public List<Car> find(){
		return carMapper.find();
	}

}
