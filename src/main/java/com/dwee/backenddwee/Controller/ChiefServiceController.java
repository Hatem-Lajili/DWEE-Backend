package com.dwee.backenddwee.Controller;


import com.dwee.backenddwee.Models.ChiefService;
import com.dwee.backenddwee.Service.DoctorService;
import com.dwee.backenddwee.Service.Imp.ChiefServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/chiefs")
public class ChiefServiceController {


    @Autowired
    private ChiefServiceImp chiefServiceImp;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ChiefService> getChief(@PathVariable String id) {
        return ResponseEntity.ok(chiefServiceImp.getChief(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ChiefService>> getAllChiefs() {
        return ResponseEntity.ok(chiefServiceImp.getAllChiefs());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> addChief(@RequestBody ChiefService chiefService) {
        String id = chiefServiceImp.addChief(chiefService);
        return ResponseEntity.created(URI.create(String.format("/chiefs/%s", id))).build();
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ChiefService> updateChief(@RequestBody ChiefService chiefService) {
        return ResponseEntity.ok(chiefServiceImp.updateChief(chiefService));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<Void> deleteChiefById(@PathVariable String id) {
        chiefServiceImp.deleteChief(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id-chief}/doctors/{id-doctor}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CHIEF_SERVICE')")
    public ResponseEntity<Void> deleteDoctorFromChief(@PathVariable("id-chief") String idChiefService,
                                                      @PathVariable("id-doctor") String idDoctorToDelete) {
        chiefServiceImp.deleteDoctor (idChiefService,idDoctorToDelete);
        doctorService.deleteDoctor(idDoctorToDelete);
        return ResponseEntity.noContent().build();
    }


}
