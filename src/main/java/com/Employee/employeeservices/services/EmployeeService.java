package com.Employee.employeeservices.services;

import com.Employee.employeeservices.pojos.EmployeeDepartmentPojo;
import com.Employee.employeeservices.pojos.EmployeePojo;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    int addEmployee(EmployeePojo detail);

    EmployeeDepartmentPojo getEmployee(int employeeId);

    int updateEmployee(EmployeePojo detail);

    void deleteEmployee(int employeeId);
}
