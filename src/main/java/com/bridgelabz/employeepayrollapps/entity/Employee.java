package com.bridgelabz.employeepayrollapps.entity;

import com.bridgelabz.employeepayrollapps.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String gender;
    private String startDate;

    private long salary;
    private String note;
    private String profilePic;
    @ElementCollection
    private List<String> department;


    public void UpdateEmployee(EmployeeDto employee){
        this.name=employee.getName();
        this.gender=employee.getGender();
        this.startDate=employee.getStartDate();
        this.salary=employee.getSalary();
        this.note=employee.getNote();
        this.profilePic=employee.getProfilePic();
        this.department=employee.getDepartment();

    }

    public Employee(EmployeeDto employeeDto) {
        this.name = employeeDto.getName();
        this.gender = employeeDto.getGender();
        this.startDate = employeeDto.getStartDate();
        this.salary=employeeDto.getSalary();
        this.note= employeeDto.getNote();
        this.profilePic= employeeDto.getProfilePic();
        this.department = employeeDto.getDepartment();
    }

}
