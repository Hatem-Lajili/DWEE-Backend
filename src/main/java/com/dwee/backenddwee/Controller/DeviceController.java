package com.dwee.backenddwee.Controller;

import com.dwee.backenddwee.ModelMapper;
import com.dwee.backenddwee.Models.Device;
import com.dwee.backenddwee.Models.DeviceHistory;
import com.dwee.backenddwee.Service.DeviceHistoryService;
import com.dwee.backenddwee.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceHistoryService deviceHistoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable String id) {
        return ResponseEntity.ok(deviceService.getDevice(id));
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDoctors() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @PostMapping
    public ResponseEntity<Object> addDevice(@RequestBody Device device) {
        String id = deviceService.addDevice(device);
        final var deviceHistory = modelMapper.map(device);
        deviceHistoryService.addDeviceHistory(deviceHistory);
        return ResponseEntity.created(URI.create(String.format("/devices/%s", id))).build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<DeviceHistory>> searchDoctorByFirstname(@RequestParam("query") String idDevice) { return ResponseEntity.ok(deviceHistoryService.searchDeviceByidDevice(idDevice));}


    @PutMapping
    public ResponseEntity<Device> updateDevice(@RequestBody Device device) {
        final var updatedDevice = deviceService.updateDevice(device);
        final var deviceHistory = modelMapper.map(device);
        deviceHistoryService.addDeviceHistory(deviceHistory);
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteDeviceById(@PathVariable String id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
