package com.dwee.backenddwee.Controller;


import com.dwee.backenddwee.Entity.ChfS;
import com.dwee.backenddwee.Repository.ChfSRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChfSController {
    @Autowired
    ChfSRepo chfSRepo;

    @PostMapping("/addchef")
    public ChfS createChfs(@RequestBody ChfS chfS){
        chfSRepo.save(chfS);
        return chfS;
    }

    @GetMapping("/chefs")
    public List listChefs(){
        return chfSRepo.findAll();
    }

    @PutMapping("update/{id}")
    public ChfS updateChfS(@RequestBody ChfS chfS,@PathVariable String id){
        chfS.setId(id);
        chfSRepo.save(chfS);
        return chfS;
    }

    @DeleteMapping("deleteChef/{id}")
    public String deleteChfS(@PathVariable String id){
        chfSRepo.deleteById(id);
        return id + "Deleted successfully !";
    }

  /*  @GetMapping("/{first_name}/doctor")
    public ChfS listChfS(@PathVariable String first_name){
        return chfSRepo.findDoctorByFirst_name(first_name);
    } */


}
