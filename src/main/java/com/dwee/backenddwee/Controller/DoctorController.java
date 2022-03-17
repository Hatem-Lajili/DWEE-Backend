package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Entity.Doctor;
import com.dwee.backenddwee.Repository.DoctorRepo;
import com.dwee.backenddwee.Service.DoctorSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DoctorController {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private DoctorSer doctorSer;

    @PostMapping("/add")
    public ResponseEntity addDoctor (@RequestBody Doctor doctor){
        doctorSer.addDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorSer.getAllDoctors());
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor>getDoctorById(@PathVariable String id){
        return ResponseEntity.ok(doctorSer.getDoctorById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable  String id){
        doctorSer.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
