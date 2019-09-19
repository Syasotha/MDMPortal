package com.virtusa.vtaf.Service;

import java.util.List;

import com.virtusa.vtaf.Model.Device;

public interface DeviceService {

	public List<Device> getAllDevice();

	public boolean addDevice(Device device);

}
