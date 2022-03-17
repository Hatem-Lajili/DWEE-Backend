package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Entity.Doctor;
import com.dwee.backenddwee.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorSer {
    @Autowired
    DoctorRepo doctorRepo;

    public void addDoctor(Doctor doctor){
        doctorRepo.insert(doctor);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(String id){
        return doctorRepo.findById(id)
                .orElseThrow(()-> new RuntimeException(
                String.format("cannot find doctor by id %s", id)
        ));
    }
    public String deleteAll(){
         doctorRepo.deleteAll();
         return "All Doctors are deleted!";
    }
    public void deleteDoctor(String id){
        doctorRepo.deleteById(id);
    }
}
