package com.anz.res.res.vo;

import com.anz.res.res.domain.Department;
import com.anz.res.res.domain.Employee;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public class EmployeeVo extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1957657325846260628L;

	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
