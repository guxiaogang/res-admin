package com.anz.res.res.service.impl;

import java.io.Serializable;
import java.util.List;

import com.anz.res.res.dao.BaseMapper;
import com.anz.res.res.service.BaseService;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public abstract class AbstractServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	private BaseMapper<T, ID> baseMapper;

	protected abstract void setBaseMapper();

	public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public int deleteObjectByPK(ID id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertObjectSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	@Override
	public T findObjectByPK(ID id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateObjectByPKSelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateObjectByPK(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertObject(T record) {
		return baseMapper.insert(record);
	}
	
	@Override
	public List<T> findAll() {
		return baseMapper.findAll();
	}

}
