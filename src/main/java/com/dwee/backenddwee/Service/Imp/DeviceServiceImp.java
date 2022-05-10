package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Exception.EntityNotFoundException;
import com.dwee.backenddwee.Models.Device;
import com.dwee.backenddwee.Repository.DeviceRepository;
import com.dwee.backenddwee.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;


    @Override
    public Device getDevice(String id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("cannot find device by id %s", id)
                ));
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public String addDevice(Device device) {
        return deviceRepository.insert(device).getId();
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(String id) {
        deviceRepository.deleteById(id);
    }


}
