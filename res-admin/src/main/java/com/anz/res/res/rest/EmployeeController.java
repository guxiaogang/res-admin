package com.anz.res.res.rest;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anz.res.res.domain.Department;
import com.anz.res.res.domain.Employee;
import com.anz.res.res.service.DepartmentService;
import com.anz.res.res.service.EmployeeService;
import com.anz.res.res.vo.EmployeeVo;
import com.anz.res.util.IdGenerator;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */
@RestController
@RequestMapping("/res/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Resource(name = "employeeService")
	private EmployeeService employeeService;

	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAll() {
		List<Employee> list = employeeService.findAll();
		logger.debug("findAll count:{}", list.size());
		return list;
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody EmployeeVo get(@PathVariable("employeeId") Long employeeId) {
		EmployeeVo vo = new EmployeeVo();
		Employee employee = employeeService.findObjectByPK(employeeId);
		if (employee != null) {
			BeanUtils.copyProperties(employee, vo);
		}

		Department dep = departmentService.findObjectByPK(employee.getDepId());
		vo.setDepartment(dep);
		return vo;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void create(@RequestBody Employee employee) {
		employee.setId(IdGenerator.generateId());
		employeeService.insertObjectSelective(employee);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Employee employee) {
		employeeService.updateObjectByPK(employee);
	}

	@RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("empId") Long empId) {
		employeeService.deleteObjectByPK(empId);
	}

}
