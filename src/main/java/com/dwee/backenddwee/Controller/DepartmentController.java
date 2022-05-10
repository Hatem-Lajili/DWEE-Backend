package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.Department;
import com.dwee.backenddwee.Service.Imp.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    DepartmentServiceImp departmentServiceImp;

    @PostMapping
    public ResponseEntity addDepartment (@RequestBody Department department){
        departmentServiceImp.addDepartment(department);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentServiceImp.getAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department>getDepartmentById(@PathVariable String id){
        return ResponseEntity.ok(departmentServiceImp.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public Department departmentToUpdate( @RequestBody Department department, @PathVariable String id) {
        return departmentServiceImp.updateDepartment(department,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable  String id){
        departmentServiceImp.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public String deleteAll(){
        departmentServiceImp.deleteAllDepartment();
        return "All departments are deleted";
    }
}
