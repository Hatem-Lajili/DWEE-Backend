package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.Department;
import com.dwee.backenddwee.Service.DepartmentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentSer departmentSer;

    @PostMapping("/addDepartment")
    public ResponseEntity addDepartment (@RequestBody Department department){
        departmentSer.addDepartment(department);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(departmentSer.getAllDepartment());
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department>getDepartmentById(@PathVariable String id){
        return ResponseEntity.ok(departmentSer.getDepartmentById(id));
    }

    @PutMapping("/updateDepartment/{id}")
    public Department departmentToUpdate( @RequestBody Department department, @PathVariable String id) {
        return departmentSer.updateDepartment(department,id);
    }

    @DeleteMapping("deleteDepartment/{id}")
    public ResponseEntity deleteDoctor(@PathVariable  String id){
        departmentSer.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAllDepartment")
    public String deleteAll(){
        departmentSer.deleteAll();
        return "All departments are deleted";
    }
}
