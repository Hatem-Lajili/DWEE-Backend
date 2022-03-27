package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.ChfS;
import com.dwee.backenddwee.Models.Doctor;
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
    private DoctorSer doctorSer;
    @Autowired
    private DoctorRepo doctorRepo;

    @PostMapping("/addDoctor")
    public ResponseEntity addDoctor (@RequestBody Doctor doctor){
        doctorSer.addDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorSer.getAllDoctors());
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor>getDoctorById(@PathVariable String id){
        return ResponseEntity.ok(doctorSer.getDoctorById(id));
    }

    @PutMapping("updateDoctor/{id}")
    public Doctor updateChfS(@RequestBody Doctor doctor,@PathVariable String id){
        doctor.setId(id);
        doctorRepo.save(doctor);
        return doctor;
    }

    @DeleteMapping("deleteDoctor/{id}")
    public ResponseEntity deleteDoctor(@PathVariable  String id){
        doctorSer.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAllDoctors")
    public String deleteAll(){
        doctorSer.deleteAll();
        return "All doctors are deleted";
    }


}
