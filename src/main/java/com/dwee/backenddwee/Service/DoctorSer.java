package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorSer {
    @Autowired
    DoctorRepo doctorRepo;

    public void addDoctor(Doctor doctor) {
        doctorRepo.insert(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor getDoctorById(String id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("cannot find doctor by id %s", id)
                ));
    }

    public Doctor updateDoctor(Doctor doctor, String id) {
        Doctor doctorToUpdate = new Doctor();
        doctorToUpdate = doctorRepo.findById(id).get();
        if (doctorToUpdate != null) {
            doctorToUpdate.setUsername(doctor.getUsername());
            doctorToUpdate.setEmail(doctor.getEmail());
            doctorToUpdate.setPassword(doctor.getPassword());
          //  doctorToUpdate.setMachines(doctor.getMachines());
            return doctorRepo.save(doctorToUpdate);
        } else {
            return null;
        }
    }
        public String deleteAllDoctor () {
            doctorRepo.deleteAll();
            return "All Doctors are deleted!";
        }
        public void deleteDoctor (String id){
            doctorRepo.deleteById(id);
        }
}

