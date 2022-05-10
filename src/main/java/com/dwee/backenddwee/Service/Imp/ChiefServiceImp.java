package com.dwee.backenddwee.Service.Imp;

import com.dwee.backenddwee.Exception.EntityNotFoundException;
import com.dwee.backenddwee.Models.ChiefService;
import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Repository.ChiefServiceRepository;
import com.dwee.backenddwee.Service.IChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChiefServiceImp implements IChiefService {

    @Autowired
    ChiefServiceRepository chiefServiceRepository;

    @Override
    public ChiefService getChief(String id) {
        return chiefServiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("cannot find chief by id %s", id)
                ));
    }

    @Override
    public List<ChiefService> getAllChiefs() {
        return chiefServiceRepository.findAll();
    }

    @Override
    public String addChief(ChiefService chiefService) {
        return chiefServiceRepository.insert(chiefService).getId();
    }

    @Override
    public ChiefService updateChief(ChiefService chiefService) {
        return chiefServiceRepository.save(chiefService);
    }

    @Override
    public void deleteChief(String id) {
        chiefServiceRepository.deleteById(id);
    }

    @Override
    public void addDoctor(String idChiefService, Doctor doctor) {
        ChiefService chiefService = getChief(idChiefService);
        if( null == chiefService.getDoctors()){
            chiefService.setDoctors(Collections.singletonList(doctor));
        } else {
            chiefService.getDoctors().add(doctor);
        }
        updateChief(chiefService);
    }

    @Override
    public void deleteDoctor(String idChiefService, String idDeletedDoctor) {
        ChiefService chiefService = getChief(idChiefService);
        chiefService.getDoctors().removeIf(doctor -> doctor.getId().equals(idDeletedDoctor));
        updateChief(chiefService);
    }
}
