package com.anz.res.res.rest;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anz.res.exception.ServiceFailureException;
import com.anz.res.res.domain.Department;
import com.anz.res.res.service.DepartmentService;
import com.anz.res.util.IdGenerator;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

@RestController
@RequestMapping("/dep")
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Department> findAll() {
		List<Department> list = departmentService.findAll();
		logger.debug("findAll count:{}", list.size());
		return list;
	}

	@RequestMapping(value = "/{depId}", method = RequestMethod.GET)
	public @ResponseBody Department get(@PathVariable("depId") Long depId) {
		logger.debug("get department detail info:{}", depId);
		Department dep = departmentService.getDepartmentDetail(depId);
		return dep;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void create(@RequestBody Department dep) {
		validateAdd(dep);
		dep.setId(IdGenerator.generateId());
		departmentService.createDepartmentByParentDep(dep);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Department dep) {
		logger.debug("update department:{}", dep.getId());
		departmentService.updateObjectByPKSelective(dep);
	}

	@RequestMapping(value = "/{depId}", method = RequestMethod.DELETE)
	public void delete(Long depId) {
		logger.debug("delete department:{}", depId);
		departmentService.deleteDepartmentDetailById(depId);
	}

	private void validateAdd(Department dep) {
		if (StringUtils.isEmpty(dep.getName())) {
			throw ServiceFailureException.INVALID_PAR;
		}
		if (!StringUtils.isEmpty(dep.getParentDepId())) {
			Department parDp = departmentService.findObjectByPK(dep.getParentDepId());
			if (parDp == null)
				throw ServiceFailureException.INVALID_PAR;
		}
	}
}
