package com.dwee.backenddwee.Service;

import com.dwee.backenddwee.Models.Device;
import com.dwee.backenddwee.Models.DeviceHistory;

import java.util.List;

public interface DeviceHistoryService {

    DeviceHistory getDeviceHistory(String id);

    List<DeviceHistory> getAllDeviceHistories();

    String addDeviceHistory(DeviceHistory deviceHistory);

    DeviceHistory updateDeviceHistory(DeviceHistory deviceHistory);

    void deleteDeviceHistory (String id);

    List<DeviceHistory> searchDeviceByidDevice(String idDevice);


}
