/*
 *
 * All rights reserved.
 */
package com.Employee.employeeservices.response.message;


public enum CustomFailureEnum {

    ERROR_EMPLOYEE_ID_NOT_FOUND(11011, "Employee ID not found");


    private int message_code;

    private String message;

    private CustomFailureEnum(int message_code, String message) {
        this.message_code = message_code;
        this.message = message;
    }

    public int getMessage_code() {
        return message_code;
    }

    ;

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
