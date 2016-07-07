package com.anz.res.res.dao;

import java.util.List;

import com.anz.res.res.domain.Employee;

public interface EmployeeMapper extends BaseMapper<Employee, Long> {

	/**
	 * Retrieve all the employees that belong to this department
	 * 
	 * @param depId
	 * @return
	 */
	List<Employee> findEmployeesByDepId(Long depId);

	/**
	 * delete the employees that belong to this department
	 * 
	 * @param depId
	 */
	void deleteEmployeesByDepId(Long depId);
}