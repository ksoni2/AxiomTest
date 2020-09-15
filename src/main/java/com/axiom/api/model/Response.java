/**
 * 
 */
package com.axiom.api.model;

import java.util.List;

import com.axiom.api.entity.Mobile;


public class Response {

	private String status;
	private List<Mobile> devices;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Mobile> getDevices() {
		return devices;
	}

	public void setDevices(List<Mobile> devices) {
		this.devices = devices;
	}

}
