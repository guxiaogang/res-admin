package com.anz.res.res.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anz.res.res.domain.Department;
import com.anz.res.res.vo.DepartmentVo;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring/application-ctx.xml")
public class DepartmentServiceTest {
	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	private long roolId = 100;

	@Before
	public void setUp() {
		Department dep = new Department();
		dep.setId(roolId);
		dep.setName("Dep1");
		dep.setLocation("F2");
		dep.setOpenPersitions(2);
		departmentService.insertObject(dep);

		dep = new Department();
		dep.setId(101l);
		dep.setName("Dep2");
		dep.setParentDepId(100l);
		dep.setLocation("F3");
		dep.setOpenPersitions(2);
		departmentService.createDepartmentByParentDep(dep);

		dep = new Department();
		dep.setId(102l);
		dep.setParentDepId(101l);
		dep.setName("Dep3");
		dep.setLocation("F3");
		dep.setOpenPersitions(2);
		departmentService.createDepartmentByParentDep(dep);
	}

	@Test
	public void testGetDepartmentDetail() {
		Department dep = new Department();
		dep.setId(104l);
		dep.setParentDepId(101l);
		dep.setName("Dep4");
		dep.setLocation("F3");
		dep.setOpenPersitions(2);
		departmentService.createDepartmentByParentDep(dep);
		DepartmentVo vo = departmentService.getDepartmentDetail(101l);

		// assert parent dp is 100
		Assert.assertEquals(Long.valueOf(100), vo.getParentDep().getId());
		// has two sub deps:103,104
		Assert.assertEquals(2, vo.getSubDeps().size());

	}

	@Test
	public void testFindAll() {
		List<Department> list = departmentService.findAll();
		Assert.assertEquals(3, list.size());
	}

	@After
	public void after() {
		departmentService.deleteDepartmentDetailById(roolId);
		DepartmentVo vo = departmentService.getDepartmentDetail(101l);
		Assert.assertEquals(null, vo);
	}
}
