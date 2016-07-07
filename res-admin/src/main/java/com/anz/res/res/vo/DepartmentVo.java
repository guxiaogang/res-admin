package com.anz.res.res.vo;

import java.util.List;

import com.anz.res.res.domain.Department;
import com.anz.res.res.domain.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = { "path" })
public class DepartmentVo extends Department {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7422816359161121225L;

	private Department parentDep;

	private Employee manager;

	private List<Department> subDeps;
	
	private List<Employee> employees;

	public Department getParentDep() {
		return parentDep;
	}

	public Employee getManager() {
		return manager;
	}

	public List<Department> getSubDeps() {
		return subDeps;
	}

	public void setParentDep(Department parentDep) {
		this.parentDep = parentDep;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public void setSubDeps(List<Department> subDeps) {
		this.subDeps = subDeps;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
