package com.anz.res.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.res.res.dao.EmployeeMapper;
import com.anz.res.res.domain.Employee;
import com.anz.res.res.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, Long> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    protected void setBaseMapper() {
        super.setBaseMapper(employeeMapper);
    }

}