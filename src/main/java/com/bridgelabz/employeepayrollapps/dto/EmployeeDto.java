package com.bridgelabz.employeepayrollapps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.ElementCollection;
import javax.validation.constraints.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @Pattern(regexp="^[A-Z]{1}[a-z]{2,}",message = "please enter valid name")
    private String name;
    @Pattern(regexp="male|female|other|Male|Female",message="please enter the valid gender")
    private String gender;
    @NotBlank
    private String startDate;
    @Min(10000)
    @Max(100000)
    private long salary;
    @NotEmpty
    private String note;
    private String profilePic;

    @ElementCollection
    private List<String> department;
}
