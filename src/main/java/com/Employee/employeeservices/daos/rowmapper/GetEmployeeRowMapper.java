package com.Employee.employeeservices.daos.rowmapper;

import com.Employee.employeeservices.pojos.EmployeePojo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployeeRowMapper implements RowMapper<EmployeePojo> {
    @Override
    public EmployeePojo mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployeeId(rs.getInt("id"));
        employeePojo.setEmployeeName(rs.getString("employee_name"));
        employeePojo.setSalary(rs.getInt("salary"));
        employeePojo.setDateOfBirth(rs.getString("birth_date"));
        employeePojo.setDepartmentId(rs.getInt("department_id"));
        return employeePojo;
    }
}
