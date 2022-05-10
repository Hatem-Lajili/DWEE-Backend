package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.ModelMapper;
import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Models.request.DoctorRequest;
import com.dwee.backenddwee.Service.Imp.ChiefServiceImp;
import com.dwee.backenddwee.Service.Imp.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {


    @Autowired
    private DoctorServiceImp doctorServiceImp;

    @Autowired
    private ChiefServiceImp chiefServiceImp;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable String id) {
        return ResponseEntity.ok(doctorServiceImp.getDoctor(id));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorServiceImp.getAllDoctors());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctorByFirstname(@RequestParam("query") String firstname) { return ResponseEntity.ok(doctorServiceImp.searchDoctorByFirstname(firstname));}

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CHIEF_SERVICE')")
    public ResponseEntity<Object> addDoctor(@RequestBody DoctorRequest request) {
        Doctor doctor = modelMapper.map(request);
        String id = doctorServiceImp.addDoctor(doctor);
        chiefServiceImp.addDoctor(request.getChiefServiceId(), doctor);
        return ResponseEntity.created(URI.create(String.format("/doctors/%s", id))).build();
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor ,@PathVariable String id) {
        return doctorServiceImp.updateDoctor(doctor, id);    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CHIEF_SERVICE')")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable String id) {
        doctorServiceImp.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

}
