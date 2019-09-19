package com.virtusa.vtaf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.vtaf.Model.Device;
import com.virtusa.vtaf.Repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public boolean addDevice(Device device) {
		deviceRepository.save(device);
		return device != null;
	}

	@Override
	public List<Device> getAllDevice() {
		return deviceRepository.findAll();
	}
}
