package com.dwee.backenddwee.Repository;


import com.dwee.backenddwee.Models.ChiefService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChiefServiceRepository extends MongoRepository<ChiefService,String> {
    //void insert(String idChiefService, List<Doctor> doctors);
}
