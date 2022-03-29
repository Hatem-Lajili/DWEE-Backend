package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Machine;
import com.dwee.backenddwee.Repository.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineSer {
    @Autowired
    MachineRepo machineRepo;

    public void addMachine(Machine machine) {
        machineRepo.insert(machine);
    }

    public List<Machine> getAllMachine() {
        return machineRepo.findAll();
    }

    public Machine getMachineById(String id) {
        return machineRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("cannot find machine by id %s", id)
                ));
    }

    public Machine updateMachine(Machine machine, String id) {
        Machine machineToUpdate = new Machine();
        machineToUpdate = machineRepo.findById(id).get();
        if (machineToUpdate != null) {
            machineToUpdate.setFlow(machine.getFlow());
            machineToUpdate.setTemperature(machine.getTemperature());
            machineToUpdate.setFio2(machine.getFio2());
            machineToUpdate.setSpo2(machine.getSpo2());
            return machineRepo.save(machineToUpdate);
        } else {
            return null;
        }
    }
    public String deleteAllMachine () {
        machineRepo.deleteAll();
        return "All Doctors are deleted!";
    }
    public void deleteMachineById (String id){
        machineRepo.deleteById(id);
    }
}
