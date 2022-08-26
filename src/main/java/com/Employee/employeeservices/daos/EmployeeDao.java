package com.Employee.employeeservices.daos;

import com.Employee.employeeservices.pojos.EmployeePojo;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeDao {
    int addEmployee(EmployeePojo detail);
    EmployeePojo getEmployee(int employeeId);
    int updateEmployee(EmployeePojo detail);
    void deleteEmployee(int employeeId);
}
