package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Models.ERole;
import com.dwee.backenddwee.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
