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
 * ҵ���߼���  ��spring����
 * @author Administrator
 * service ҵ���߼���,�� Spring ����
 */
@Service("carService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CarService {
  // Spring -> Mybatis (ͨ��ע�ⷽʽע�� mapper ʵ��)
  @Resource(name = "carMapper")
  private CarMapper carMapper;

  // ע������:����Ҫ������,û������һ��������;���뼶�� commited-read;�ع�����
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
          rollbackFor = Exception.class)
  	public int add(Car car){
		return carMapper.add(car);
	}
	
	public List<Car> find(){
		return carMapper.find();
	}

}
