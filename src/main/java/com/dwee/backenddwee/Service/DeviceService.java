package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Device;


import java.util.List;

public interface DeviceService {


    String addDevice(Device device);

    List<Device> getAllDevices();

    Device getDevice(String id);

    Device updateDevice(Device device);

    void deleteDevice (String id);

}
