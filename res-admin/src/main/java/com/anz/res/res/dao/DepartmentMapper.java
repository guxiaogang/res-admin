package com.anz.res.res.dao;

import java.util.List;

import com.anz.res.res.domain.Department;

public interface DepartmentMapper extends BaseMapper<Department, Long> {

	/**
	 * Retrieve the sub-departments of this department
	 * 
	 * @param path
	 * @return sub department
	 */
	List<Department> findSubDepartmentsByPath(String path);

	/**
	 * delete the sub-departments of this department
	 * 
	 * @param path
	 */
	void deleteDepartmentByPath(String path);
}