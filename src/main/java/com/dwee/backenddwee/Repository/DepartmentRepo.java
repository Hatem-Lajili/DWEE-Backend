package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department,String> {
}
