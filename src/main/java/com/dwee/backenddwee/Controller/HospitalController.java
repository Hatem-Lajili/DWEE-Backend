package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.Hospital;
import com.dwee.backenddwee.Service.Imp.HospitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalServiceImp hospitalServiceImp;

    @GetMapping
    public Collection<Hospital> hospitals(){
        return hospitalServiceImp.getHospitals();
    }

    @PostMapping
    public Hospital addHospital(@RequestBody Hospital hospital){
        return hospitalServiceImp.createHospital(hospital);
    }


    @PutMapping("/{id}")
    public Hospital updateHospital(@RequestBody Hospital hospital, @PathVariable String id){
        return hospitalServiceImp.updateHospital(id, hospital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHospitalById(@PathVariable String id){
        hospitalServiceImp.deleteHospitalById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
