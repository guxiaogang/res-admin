package com.anz.res.res.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anz.res.res.dao.DepartmentMapper;
import com.anz.res.res.dao.EmployeeMapper;
import com.anz.res.res.domain.Department;
import com.anz.res.res.domain.Employee;
import com.anz.res.res.service.DepartmentService;
import com.anz.res.res.vo.DepartmentVo;

@Service("departmentService")
public class DepartmentServiceImpl extends AbstractServiceImpl<Department, Long> implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	protected void setBaseMapper() {
		super.setBaseMapper(departmentMapper);
	}

	@Override
	public void createDepartmentByParentDep(Department dep) {
		Department parDep = departmentMapper.selectByPrimaryKey(dep.getParentDepId());
		// set path 101,102,103
		if (StringUtils.isEmpty(parDep.getPath())) {
			// second level department
			dep.setPath(String.valueOf(dep.getParentDepId()) + ",");
		} else {
			dep.setPath(parDep.getPath() + dep.getParentDepId() + ",");

		}
		departmentMapper.insertSelective(dep);
	}

	@Override
	public DepartmentVo getDepartmentDetail(Long depId) {
		DepartmentVo vo = new DepartmentVo();
		Department dep = departmentMapper.selectByPrimaryKey(depId);
		// set values of this dep
		if (dep != null)
			BeanUtils.copyProperties(dep, vo);
		else
			return null;

		// set parent dep
		if (!StringUtils.isEmpty(dep.getParentDepId())) {
			Department parDep = departmentMapper.selectByPrimaryKey(dep.getParentDepId());
			vo.setParentDep(parDep);
		}

		List<Department> subDeps = departmentMapper.findSubDepartmentsByPath(buildSubDepsPath(dep));
		vo.setSubDeps(subDeps);

		// find all employees
		List<Employee> listEmps = employeeMapper.findEmployeesByDepId(depId);
		vo.setEmployees(listEmps);

		return vo;
	}

	@Override
	public void deleteDepartmentDetailById(Long depId) {
		Department dep = departmentMapper.selectByPrimaryKey(depId);
		if (dep == null)
			return;

		// delete all employee
		employeeMapper.deleteEmployeesByDepId(depId);

		// delete sub dep
		departmentMapper.deleteDepartmentByPath(buildSubDepsPath(dep));

		
		// delete self
		departmentMapper.deleteByPrimaryKey(depId);
	}

	private String buildSubDepsPath(Department dep) {
		String path = "";
		if (StringUtils.isEmpty(dep.getPath())) {
			path = dep.getId() + ",";
		} else {
			path = dep.getPath() + dep.getId() + ",";
		}
		return path;
	}

}