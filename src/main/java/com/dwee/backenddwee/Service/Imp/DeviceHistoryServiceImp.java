package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Exception.EntityNotFoundException;
import com.dwee.backenddwee.Models.DeviceHistory;
import com.dwee.backenddwee.Repository.DeviceHistoryRepository;
import com.dwee.backenddwee.Service.DeviceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceHistoryServiceImp implements DeviceHistoryService {

    @Autowired
    DeviceHistoryRepository deviceHistoryRepository;

    @Override
    public DeviceHistory getDeviceHistory(String id) {
        return deviceHistoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("cannot find doctor by id %s", id)
                ));
    }

    @Override
    public List<DeviceHistory> getAllDeviceHistories() {
        return deviceHistoryRepository.findAll();
    }

    @Override
    public List<DeviceHistory> searchDeviceByidDevice(String idDevice) {
        return deviceHistoryRepository.searchDeviceByIdDevice(idDevice);
    }

    @Override
    public String addDeviceHistory(DeviceHistory deviceHistory) {
        return deviceHistoryRepository.insert(deviceHistory).getId();
    }

    @Override
    public DeviceHistory updateDeviceHistory(DeviceHistory deviceHistory) {
        return deviceHistoryRepository.save(deviceHistory);
    }

    @Override
    public void deleteDeviceHistory(String id) {
        deviceHistoryRepository.deleteById(id);
    }


    
}
