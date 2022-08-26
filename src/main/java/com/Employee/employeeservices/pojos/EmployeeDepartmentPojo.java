package com.Employee.employeeservices.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartmentPojo {
    @JsonProperty("Employee")
    private EmployeePojo employeePojo;
    @JsonProperty("Department")
    private DepartmentPojo departmentPojo;
}
