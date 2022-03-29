package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.Models.Machine;
import com.dwee.backenddwee.Service.MachineSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class MachineController {
    @Autowired
    MachineSer machineSer;

    @PostMapping("/addMachine")
    public ResponseEntity addMachine (@RequestBody Machine machine){
        machineSer.addMachine(machine);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/machines")
    public ResponseEntity<List<Machine>> getAllMachine(){
        return ResponseEntity.ok(machineSer.getAllMachine());
    }

    @GetMapping("/machine/{id}")
    public ResponseEntity<Machine>getMachineById(@PathVariable String id){
        return ResponseEntity.ok(machineSer.getMachineById(id));
    }

    @PutMapping("/updateMachine/{id}")
    public Machine machineToUpdate( @RequestBody Machine machine, @PathVariable String id) {
        return machineSer.updateMachine(machine,id);
    }

    @DeleteMapping("deleteMachine/{id}")
    public ResponseEntity deleteMachineById(@PathVariable  String id){
        machineSer.deleteMachineById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAllMachine")
    public String deleteAllMachine(){
        machineSer.deleteAllMachine();
        return "All machines are deleted";
    }
}
