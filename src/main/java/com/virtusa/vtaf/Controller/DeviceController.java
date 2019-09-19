package com.virtusa.vtaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.vtaf.Model.Device;
import com.virtusa.vtaf.Service.DeviceService;

@RestController
public class DeviceController {
	@Autowired
	private DeviceService deviceService;

	@PostMapping("/addDevice")
	public boolean addDevice(@RequestBody Device device) {

		return deviceService.addDevice(device);

	}

	public ResponseEntity<List<Device>> get() {
		List<Device> devices = deviceService.getAllDevice();
		ResponseEntity<List<Device>> response = new ResponseEntity<>(devices, HttpStatus.OK);
		return response;

	}

}
