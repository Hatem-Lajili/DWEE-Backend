package com.dwee.backenddwee.Repository;


import com.dwee.backenddwee.Models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {
    @Query("{firstname :?0}")                                                  //SQL Equivalent : SELECT * FROM Doctor WHERE firstname=?
    List<Doctor> searchDoctorByFirstname(String firstname);

}
