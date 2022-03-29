package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Models.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepo extends MongoRepository<Machine, String> {
}
