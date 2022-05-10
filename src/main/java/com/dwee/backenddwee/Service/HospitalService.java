package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Hospital;

import java.util.Collection;

public interface HospitalService {

     Hospital createHospital(Hospital hospital);

     Hospital updateHospital(String id, Hospital hospital);

     Hospital deleteHospitalById(String id);

     Collection<Hospital> getHospitals();
}
