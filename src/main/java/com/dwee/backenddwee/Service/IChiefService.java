package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.ChiefService;
import com.dwee.backenddwee.Models.Device;
import com.dwee.backenddwee.Models.Doctor;

import java.util.List;

public interface IChiefService {

    ChiefService getChief(String id);

    List<ChiefService> getAllChiefs();

    String addChief(ChiefService chiefService);

    ChiefService updateChief(ChiefService chiefService);

    void deleteChief (String id);

    void addDoctor(String idChiefService, Doctor doctor);

    void deleteDoctor(String idChiefService, String idDoctor);
}
