package com.Employee.employeeservices.daos.impl;

import com.Employee.employeeservices.daos.EmployeeDao;
import com.Employee.employeeservices.daos.rowmapper.GetEmployeeRowMapper;
import com.Employee.employeeservices.pojos.EmployeePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addEmployee(EmployeePojo detail) {
        try {
            String sql = "INSERT INTO employee(employee_name, salary,birth_date,department_id) values(?, ?, ?, ?)";
            Object empData[] = {detail.getEmployeeName(), detail.getSalary(), detail.getDateOfBirth(), detail.getDepartmentId()};
            log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                    "addEmployee",
                    detail.getEmployeeId(),
                    "addEmployee",
                    " to add employee data",
                    sql);

            return jdbcTemplate.update(sql, empData);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeePojo getEmployee(int employeeId) {
        String sql = "SELECT * FROM employee where id =" + employeeId;
        EmployeePojo data = jdbcTemplate.queryForObject(sql, new GetEmployeeRowMapper());
        log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                "getEmployee",
                employeeId,
                "getEmployee",
                " to retrieve employee data",
                sql);
        return data;
    }

    @Override
    public int updateEmployee(EmployeePojo detail) {
        String sql = "UPDATE employee SET employee_name = ?,salary = ?,birth_date = ?,department_id = ?" +
                " WHERE id =" + detail.getEmployeeId();
        Object empData[] = {detail.getEmployeeName(), detail.getSalary(), detail.getDateOfBirth(),
                detail.getDepartmentId()};
        log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                "updateEmployee",
                detail.getEmployeeId(),
                "updateEmployee",
                " to update employee data",
                sql);
        return jdbcTemplate.update(sql, empData);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            String sql = "DELETE FROM employee WHERE id = ?";
            jdbcTemplate.update(sql, employeeId);
            log.info("event={},employeeId={}, action={}, reason={} , sql={}",
                    "deleteEmployee",
                    employeeId,
                    "deleteEmployee",
                    " to delete employee data",
                    sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
