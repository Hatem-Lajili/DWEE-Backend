package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.ChfS;
import com.dwee.backenddwee.Repository.ChfSRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChfSSer {

    @Autowired
    ChfSRepo chfsRepo;

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
    public String deleteAll(){
        chfsRepo.deleteAll();
        return "All Chiefs are deleted!";
    }
    public void deleteChfS(String id){
        chfsRepo.deleteById(id);
    }
}
