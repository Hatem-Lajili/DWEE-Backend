package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Entity.ChfS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChfSRepo extends MongoRepository<ChfS,String> {
}
