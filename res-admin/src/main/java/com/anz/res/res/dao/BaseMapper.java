package com.anz.res.res.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public interface BaseMapper<T, ID extends Serializable> {

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	int deleteByPrimaryKey(ID id);
	
	List<T> findAll();

}
