package com.codeid.eshopper.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeid.eshopper.model.Employee;
import com.codeid.eshopper.service.DepartmentService;



@Controller
public class IndexController {
    private final DepartmentService departmentService;

    
    public IndexController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("title", "Hello Bootcamp Java 2025");
        model.addAttribute("departments", departmentService.findAllDepartment());
        return "index";
    }

    @GetMapping("/employee")
    public String showEmployee(Model model){
        var emp1 = new Employee("Widi", LocalDate.of(2025,1,1), 4_000);
        var emp2 = new Employee("Yuli", LocalDate.of(2025,1,1), 4_000);
        var emps = Arrays.asList(emp1,emp2);

        //arg0: sebagai alias yang akan dicall di file html
        //arg1: berisi data list employees
        model.addAttribute("employees", emps);
        
        //call file employee.html
        return "employee";
    }
    
}
