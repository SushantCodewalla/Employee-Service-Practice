package com.Employee.employeeservices.controllers;

import com.Employee.employeeservices.pojos.EmployeeDepartmentPojo;
import com.Employee.employeeservices.pojos.EmployeePojo;
import com.Employee.employeeservices.response.APIResponse;
import com.Employee.employeeservices.response.message.CustomSuccessEnum;
import com.Employee.employeeservices.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add_employee")
    public ResponseEntity<APIResponse> addEmployee(@RequestBody EmployeePojo employeePojo) {

        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "addEmployee",
                "addEmployee",
                "to add employee",
                "Started",
                employeePojo
        );
        Map<String, Object> dataObject = new HashMap<>();
        employeeService.addEmployee(employeePojo);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "addEmployee",
                "addEmployee",
                "to add employee",
                "Completed",
                employeePojo
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_EMPLOYEE_ADDED, dataObject), HttpStatus.OK);
    }

    @GetMapping("/get_employee/{id}")
//    ResponseEntity<APIResponse> getEmployee(@PathVariable("id") Integer employeeId) {
    EmployeeDepartmentPojo getEmployee(@PathVariable("id") Integer employeeId) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "getEmployee",
                "getEmployee",
                "to get employee",
                "Started",
                employeeId
        );
        Map<String, Object> dataObject = new HashMap<>();
        EmployeeDepartmentPojo employeePojo = employeeService.getEmployee(employeeId);
//        dataObject.put("employee_id", employeePojo.g());
//        dataObject.put("employee_name", employeePojo.getEmployeeName());
//        dataObject.put("salary", employeePojo.getSalary());
//        dataObject.put("date of birth", employeePojo.getDateOfBirth());
//        dataObject.put("department_id",employeePojo.getDepartmentId());
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "getEmployee",
                "getEmployee",
                "to get employee",
                "Completed",
                employeeId
        );
        // return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_FETCH_EMPLOYEE, dataObject), HttpStatus.OK);
        return employeePojo;

    }


    @PutMapping("/update_employee")
    ResponseEntity<APIResponse> updateEmployee(@RequestBody EmployeePojo employeePojo) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "updateEmployee",
                "updateEmployee",
                "to update employee",
                "Started",
                employeePojo
        );
        Map<String, Object> dataObject = new HashMap<>();
        employeeService.updateEmployee(employeePojo);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "updateEmployee",
                "updateEmployee",
                "to update employee",
                "Completed",
                employeePojo
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_EMPLOYEE_UPDATED, dataObject), HttpStatus.OK);
    }

    @DeleteMapping("/delete_employee/{id}")
    ResponseEntity<APIResponse> deleteEmployee(@PathVariable("id") Integer departmentId) {
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "deleteEmployee",
                "deleteEmployee",
                "to delete employee",
                "Started",
                departmentId
        );
        Map<String, Object> dataObject = new HashMap<>();
        employeeService.deleteEmployee(departmentId);
        log.info("service={},event={},action={},reason={},status={},data={}",
                "Employee-Service",
                "deleteEmployee",
                "deleteEmployee",
                "to delete employee",
                "Completed",
                departmentId
        );
        return new ResponseEntity<>(new APIResponse(true, CustomSuccessEnum.SUCCESS_EMPLOYEE_DELETED, dataObject), HttpStatus.OK);


    }
}
