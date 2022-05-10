package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Exception.EntityNotFoundException;
import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Models.Hospital;
import com.dwee.backenddwee.Repository.DoctorRepository;
import com.dwee.backenddwee.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    @Override
    public Doctor getDoctor(String id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("cannot find doctor by id %s", id)
                ));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> searchDoctorByFirstname(String firstname) {
        return doctorRepository.searchDoctorByFirstname(firstname);
    }

    @Override
    public String addDoctor(Doctor doctor) {
        return doctorRepository.insert(doctor).getId();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, String id) {
        Doctor doctorToUpdate;
        doctorToUpdate = doctorRepository.findById(id).get();
        if(doctorToUpdate!=null){
            doctorToUpdate.setFirstname(doctor.getFirstname());
            doctorToUpdate.setLastname(doctor.getLastname());
            doctorToUpdate.setEmail(doctor.getEmail());
            doctorToUpdate.setPhonenumber(doctor.getPhonenumber());
            doctorToUpdate.setGender(doctor.getGender());
            doctorToUpdate.setBirthDate(doctor.getBirthDate());
            return  doctorRepository.save(doctorToUpdate);

        }else {
            return null;
        }
    }

    @Override
    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }



}
