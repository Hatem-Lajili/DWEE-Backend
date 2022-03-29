package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.ChfS;
import com.dwee.backenddwee.Models.Doctor;
import com.dwee.backenddwee.Repository.ChfSRepo;
import com.dwee.backenddwee.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChfSSer {

    @Autowired
    ChfSRepo chfsRepo;

    @Autowired
    DoctorRepo doctorRepo;

    public void addChfS(ChfS chfS){
        chfsRepo.insert(chfS);
    }
    public List<ChfS> getAllChfs(){
        return chfsRepo.findAll();
    }
    public ChfS getChfSById(String id){
        return chfsRepo.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        String.format("cannot find chiefs by id %s", id)
                ));
    }
    public ChfS updateChfs(ChfS chfS, String id) {
        ChfS chiefToUpdate = new ChfS();
        chiefToUpdate = chfsRepo.findById(id).get();
        if(chiefToUpdate!=null){
            chiefToUpdate.setUsername(chfS.getUsername());
            chiefToUpdate.setEmail(chfS.getEmail());
            chiefToUpdate.setPassword(chfS.getPassword());
            chiefToUpdate.setDoctors(chfS.getDoctors());

            return chfsRepo.save(chiefToUpdate);
        }else {
            return null;
        }
    }
    public  void addDoctor(ChfS chfS,String id){
        Doctor doctor = doctorRepo.findById(id).get();
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        chfS.setDoctors(doctors);
        chfsRepo.save(chfS);
    }
    //add list Doctors to Chief Service
    public ChfS addListDoctors(ChfS chfS, String id){
        List<Doctor> doctorList = doctorRepo.findAll();
        doctorList.addAll(doctorList);
        chfS.setDoctors(doctorList);
        chfsRepo.save(chfS);
        return new ChfS();
    }

    public void deleteChfS(String id){
        chfsRepo.deleteById(id);
    }

    public String deleteAll(){
        chfsRepo.deleteAll();
        return "All Chiefs are deleted!";
    }

}
