package com.dwee.backenddwee.Controller;


import com.dwee.backenddwee.Models.ChfS;
import com.dwee.backenddwee.Service.ChfSSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChfSController {


    @Autowired
    private ChfSSer chfSSer;


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
    @PutMapping("/adddoctors/{id}")
    public ResponseEntity addDoctor(@RequestBody ChfS chfS, @PathVariable String id){
         chfSSer.addDoctor(chfS,id);
         return ResponseEntity.ok().build();
    }
    //ajoutList
    @PutMapping("/addListDoctor/{id}")
    public ResponseEntity addListDoctor(@RequestBody ChfS chfS,@PathVariable String id){
        chfSSer.addListDoctors(chfS,id);
        return ResponseEntity.ok().build();
        }

    @PutMapping("/updateChief/{id}")
    public ChfS chiefToUpdate(@RequestBody ChfS chfS, @PathVariable String id) {
        return chfSSer.updateChfs(chfS,id);
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
