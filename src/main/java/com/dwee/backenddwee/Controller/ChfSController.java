package com.dwee.backenddwee.Controller;


import com.dwee.backenddwee.Models.ChfS;
import com.dwee.backenddwee.Repository.ChfSRepo;
import com.dwee.backenddwee.Service.ChfSSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChfSController {


    @Autowired
    private ChfSSer chfSSer;
    @Autowired
    private ChfSRepo chfSRepo;

    @PostMapping("/addChief")
    public ResponseEntity createChiefs (@RequestBody ChfS chfS){
        chfSSer.addChfS(chfS);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/chiefs")
    public ResponseEntity<List<ChfS>> getAllChiefs(){
        return ResponseEntity.ok(chfSSer.getAllChfs());
    }

    @GetMapping("/chiefs/{id}")
    public ResponseEntity<ChfS>getChiefsById(@PathVariable String id){
        return ResponseEntity.ok(chfSSer.getChfSById(id));
    }

    @PutMapping("updateChief/{id}")
    public ChfS updateChfS(@RequestBody ChfS chfS,@PathVariable String id){
        chfS.setId(id);
        chfSRepo.save(chfS);
        return chfS;
    }

    @DeleteMapping("deleteChief/{id}")
    public ResponseEntity deleteChiefById(@PathVariable  String id){
        chfSSer.deleteChfS(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAllChiefs")
    public String deleteAll(){
        chfSSer.deleteAll();
        return "All chiefs are deleted";
    }


}
