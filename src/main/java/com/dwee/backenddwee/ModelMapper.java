package com.dwee.backenddwee;

import com.dwee.backenddwee.Models.ChiefService;
import com.dwee.backenddwee.Models.Device;
import com.dwee.backenddwee.Models.DeviceHistory;
import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Models.request.ChiefServiceRequest;
import com.dwee.backenddwee.Models.request.DoctorRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModelMapper {

    public Doctor map(DoctorRequest dto){
        final Doctor entity = new Doctor();
        entity.setEmail(dto.getEmail());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setGender(dto.getGender());
        entity.setPhonenumber(dto.getPhonenumber());
        entity.setBirthDate(dto.getBirthDate());
        return entity;

    }

    public ChiefService map(ChiefServiceRequest dto){
        final ChiefService entity = new ChiefService();
        entity.setEmail(dto.getEmail());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setGender(dto.getGender());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setBirthDate(dto.getBirthDate());
     //   entity.setIdDoctors(dto.getIdDoctors());

        return entity;
    }

    public DeviceHistory map(Device device){
        final var deviceHistory = new DeviceHistory();

        deviceHistory.setUpdateTime(LocalDateTime.now());

        deviceHistory.setErrorMessage(device.getErrorMessage());
        deviceHistory.setFio2(device.getFio2());
        deviceHistory.setSpo2(device.getSpo2());
        deviceHistory.setFlow(device.getFlow());
        deviceHistory.setTemperature(device.getTemperature());
        deviceHistory.setErrorMessage(device.getErrorMessage());
        deviceHistory.setLastRefreshed(device.getLastRefreshed());
        deviceHistory.setConnected(device.isConnected());
        deviceHistory.setWorkingProperly(device.isWorkingProperly());
        deviceHistory.setIdDevice(device.getIdDevice());

        return deviceHistory;
    }

}
