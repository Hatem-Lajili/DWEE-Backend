package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor,String> {
}
