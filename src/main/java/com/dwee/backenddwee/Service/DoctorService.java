package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Models.User;
import com.dwee.backenddwee.Models.request.DoctorRequest;

import java.util.List;

public interface DoctorService {

    String addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctor(String id);

    Doctor updateDoctor(Doctor doctor, String id);

    void deleteDoctor (String id);

    List<Doctor> searchDoctorByFirstname(String firstname);
}
