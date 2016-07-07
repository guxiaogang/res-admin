package com.anz.res.res.service;

import com.anz.res.res.domain.Department;
import com.anz.res.res.vo.DepartmentVo;

public interface DepartmentService extends BaseService<Department, Long> {

	/***
	 * get department detail info
	 * 
	 * @param depId
	 * @return
	 */
	DepartmentVo getDepartmentDetail(Long depId);

	/**
	 * create Department
	 * 
	 * @param dep
	 */
	void createDepartmentByParentDep(Department dep);

	/**
	 * delete department detail info,include sub dep,employee
	 */
	void deleteDepartmentDetailById(Long depId);

}