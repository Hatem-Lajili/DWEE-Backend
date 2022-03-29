package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Service.DoctorSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {


    @Autowired
    private DoctorSer doctorSer;
    

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

    @PutMapping("/updateDoctor/{id}")
    public Doctor doctorToUpdate(@RequestBody Doctor doctor, @PathVariable String id) {
        return doctorSer.updateDoctor(doctor,id);
    }

    @DeleteMapping("deleteDoctor/{id}")
    public ResponseEntity deleteDoctorById(@PathVariable  String id){
        doctorSer.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAllDoctors")
    public String deleteAll(){
        doctorSer.deleteAllDoctor();
        return "All doctors are deleted";
    }


}
