package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Department;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartmentById(String id);

    Department updateDepartment(Department department, String id);

    String deleteAllDepartment();

    void deleteDepartment(String id);
}
