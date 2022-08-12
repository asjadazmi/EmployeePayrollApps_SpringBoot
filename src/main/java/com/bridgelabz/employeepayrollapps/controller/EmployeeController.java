package com.bridgelabz.employeepayrollapps.controller;

import com.bridgelabz.employeepayrollapps.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapps.dto.EmployeeResponseDto;
import com.bridgelabz.employeepayrollapps.entity.Employee;
import com.bridgelabz.employeepayrollapps.exception.UserNotFoundException;
import com.bridgelabz.employeepayrollapps.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/addemp")

    public Employee addEmployee(@RequestBody Employee employee){
        return iEmployeeService.createEmployee(employee);
    }

    @GetMapping("/getall")
    public List<Employee> getAll(){
        return iEmployeeService.getEmployee();
    }
    @GetMapping("/getbyid/{id}")
    public Employee get(@PathVariable int id){
        return iEmployeeService.getById(id);
    }
    @PutMapping("/update/{id}")
    public Employee get(@PathVariable int id,@RequestBody EmployeeDto employee){
        return iEmployeeService.UpdateEmp(id,employee);
    }
    @DeleteMapping("/del/{id}")
    public Employee deleteEm(@PathVariable int id){
        return iEmployeeService.deleteEmp(id);

    }
    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDto> addEmployees(@Valid @RequestBody EmployeeDto employeeDto){
        Employee employee=iEmployeeService.addEmployee(employeeDto);
        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto("Employee added successfully",employee);
        return new ResponseEntity<>(employeeResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllemployee(){
       return ResponseEntity.ok(iEmployeeService.getEmployeeall());

    }
    @GetMapping("/getid/{id}")
    public ResponseEntity<Employee> getByid(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(iEmployeeService.getByid(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> edit(@PathVariable int id,@RequestBody EmployeeDto employeeDto) throws UserNotFoundException {
        return ResponseEntity.ok(iEmployeeService.editEmployee(id,employeeDto));
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable int id){
        return ResponseEntity.ok(iEmployeeService.deleteEmployee(id));
    }



}
