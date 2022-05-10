package com.dwee.backenddwee.Repository;

import com.dwee.backenddwee.Models.DeviceHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceHistoryRepository extends MongoRepository<DeviceHistory, String> {
    @Query("{idDevice :?0}")
    List<DeviceHistory> searchDeviceByIdDevice(String idDevice);
}
