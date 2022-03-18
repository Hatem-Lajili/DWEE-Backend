package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Entity.ChfS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChfSRepo extends MongoRepository<ChfS,String> {

   // @Query(value="{'doctors.first_name' : ?0 }", fields = "{'doctors' : 0}")
   // ChfS findDoctorByFirst_name(String first_name);

   // List findChfSByFirst_name(String first_name);


}
