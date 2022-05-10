package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Models.Hospital;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

}
