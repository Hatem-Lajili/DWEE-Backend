package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Department;
import com.dwee.backenddwee.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentSer {
    @Autowired
    DepartmentRepo departmentRepo;
    public void addDepartment(Department department){
        departmentRepo.insert(department);
    }
    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();
    }
    public Department getDepartmentById(String id){
        return departmentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        String.format("cannot find Department by id %s", id)
                ));
    }
    public Department updateDepartment(Department department, String id) {
        Department departmentToUpdate = new Department();
        departmentToUpdate = departmentRepo.findById(id).get();
        if(departmentToUpdate!=null){
            department.setName(department.getName());
            departmentToUpdate.setNum_dep(department.getNum_dep());
            return departmentRepo.save(departmentToUpdate);
        }else {
            return null;
        }
    }
    public String deleteAll(){
        departmentRepo.deleteAll();
        return "All Departments are deleted!";
    }
    public void deleteDepartment(String id){
        departmentRepo.deleteById(id);
    }
}
