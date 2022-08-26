package com.Employee.employeeservices.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {
    private Integer employeeId;
    private String employeeName;
    private Integer salary;
    private String dateOfBirth;
    private Integer departmentId;
}
