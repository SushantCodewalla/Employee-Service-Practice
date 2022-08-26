package com.Employee.employeeservices.services.impl;

import com.Employee.employeeservices.daos.EmployeeDao;
import com.Employee.employeeservices.pojos.DepartmentPojo;
import com.Employee.employeeservices.pojos.EmployeeDepartmentPojo;
import com.Employee.employeeservices.pojos.EmployeePojo;
import com.Employee.employeeservices.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public int addEmployee(EmployeePojo detail) {
        return employeeDao.addEmployee(detail);
    }

    @Override
    public EmployeeDepartmentPojo getEmployee(int employeeId) {

        EmployeePojo employeePojo = employeeDao.getEmployee(employeeId);
        DepartmentPojo departmentPojo = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/get_department/"+employeePojo.getDepartmentId()
                ,DepartmentPojo.class);
        EmployeeDepartmentPojo employeeDepartmentPojo = new EmployeeDepartmentPojo();
        employeeDepartmentPojo.setEmployeePojo(employeePojo);
        employeeDepartmentPojo.setDepartmentPojo(departmentPojo);
        return employeeDepartmentPojo;
    }

    @Override
    public int updateEmployee(EmployeePojo detail) {
        return employeeDao.updateEmployee(detail);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }
}
