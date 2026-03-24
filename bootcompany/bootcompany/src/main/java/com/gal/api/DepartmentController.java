package com.gal.api;

import com.gal.exception.DepartmentNotFoundException;
import com.gal.model.Department;
import com.gal.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{depId}")
    public ResponseEntity<?> getDepartment(@PathVariable Integer depId) {
        Department department = departmentService.find(depId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department ID not found");
        }
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.save(department));
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer depId) {
        departmentService.delete(depId);
        return ResponseEntity.ok().build();
    }
}

