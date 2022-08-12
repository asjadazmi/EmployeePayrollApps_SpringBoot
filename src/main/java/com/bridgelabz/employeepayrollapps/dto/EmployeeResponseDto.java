package com.bridgelabz.employeepayrollapps.dto;

import lombok.Data;

@Data
public class EmployeeResponseDto {

    private String message;
    private Object data;
    public EmployeeResponseDto(String message,Object data){
        this.message=message;
        this.data=data;
    }
}
