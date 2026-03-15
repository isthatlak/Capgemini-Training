package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/department")
    public String getdepartment() {
        Department department=departmentService.find(10);
        return department.toString();
    }

}
