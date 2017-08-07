package com.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.springmybatis.pojo.Car;

@Repository("carMapper")
public interface CarMapper {
	
	

	@Insert("insert into car(id,name,price,create_date) values(#{id},#{name},#{price,jdbcType=DOUBLE},#{createDate,jdbcType=DATE})")
	@SelectKey(keyProperty="id",statement="select seq_car.nextval from dual",resultType=int.class,before=true)
	int add(Car car);
	
	//当类中属性与表中字段名不一致时 必须取别名
	@Select("select id,name,price,create_date createdate from car")
	List<Car> find();
	
	
}
