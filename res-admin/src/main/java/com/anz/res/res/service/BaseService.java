package com.anz.res.res.service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public interface BaseService<T, ID extends Serializable> {

	int deleteObjectByPK(ID id);

	int insertObject(T record);

	int insertObjectSelective(T record);

	T findObjectByPK(ID id);

	int updateObjectByPKSelective(T record);

	int updateObjectByPK(T record);

	List<T> findAll();

}
