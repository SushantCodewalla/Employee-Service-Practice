/*
 *
 * All rights reserved.
 */

package com.Employee.employeeservices.response.message;


public enum CustomSuccessEnum {

    SUCCESS_EMPLOYEE_ADDED(11012, "Employee Added Successfully."),
    SUCCESS_EMPLOYEE_DELETED(11013, "Employee Deleted Successfully."),
    SUCCESS_EMPLOYEE_UPDATED(11013, "Employee Updated Successfully."),
    SUCCESS_FETCH_EMPLOYEE(11014, "Retrieve Employee Successfully."),
    ;


    private int message_code;

    private String message;

    private CustomSuccessEnum(int message_code, String message) {
        this.message_code = message_code;
        this.message = message;
    }

    public int getMessage_code() {
        return message_code;
    }

    public void setMessage_code(int message_code) {
        this.message_code = message_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message_code + " : " + this.message;
    }
}
