package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Models.Hospital;
import com.dwee.backenddwee.Repository.HospitalRepository;
import com.dwee.backenddwee.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HospitalServiceImp implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public Hospital createHospital(Hospital hospital) {
        hospitalRepository.insert(hospital);
        return hospital;
    }

    @Override
    public Hospital updateHospital(String id, Hospital hospital) {
        Hospital hospitalToUpdate;
        hospitalToUpdate = hospitalRepository.findById(id).get();
        if(hospitalToUpdate!=null){
            hospitalToUpdate.setName_hospital(hospital.getName_hospital());
            hospitalToUpdate.setAddress(hospital.getAddress());
            hospitalToUpdate.setDepartments(hospital.getDepartments());
            return  hospitalRepository.save(hospitalToUpdate);

        }else {
            return null;
        }
    }

    @Override
    public Hospital deleteHospitalById(String id) {
        hospitalRepository.deleteById(id);
        return null;
    }

    @Override
    public Collection<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }
}
