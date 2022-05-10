package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Models.Department;
import com.dwee.backenddwee.Repository.DepartmentRepository;
import com.dwee.backenddwee.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired

    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        String.format("cannot find Department by id %s", id)
                ));
    }
    @Override

    public void addDepartment(Department department) {
        departmentRepository.insert(department);
    }

    @Override
    public Department updateDepartment(Department department, String id) {
        Department departmentToUpdate;
        departmentToUpdate = departmentRepository.findById(id).get();
        if(departmentToUpdate!=null){
            department.setName(department.getName());
            departmentToUpdate.setNum_dep(department.getNum_dep());
            return departmentRepository.save(departmentToUpdate);
        }else {
            return null;
        }
    }

    @Override
    public String deleteAllDepartment() {
        departmentRepository.deleteAll();
        return "All Departments are deleted!";
    }

    @Override
    public void deleteDepartment(String id) {

    }
}
