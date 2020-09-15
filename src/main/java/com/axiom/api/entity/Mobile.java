package com.axiom.api.entity;

import java.io.Serializable;
import java.net.URL;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mobile implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String brand;
	private String phone;
	private URL picture;
	private String sim;
	private String resolution;
	private Release release;
	private Hardware hardware;

	public Mobile(Long id, String brand, String phone, URL picture, String sim, String resolution, Hardware hardware, Release release)
	{
		super();
		this.id = id;
		this.brand = brand;
		this.phone = phone;
		this.picture = picture;
		this.sim = sim;
		this.resolution = resolution;
		this.release = release;
		this.hardware = hardware;
	}

	public Mobile() {

	}

	public Mobile(Hardware hardware, Release release) {
		this.hardware = hardware;
		this.release = release;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public URL getPicture() {
		return picture;
	}

	public void setPicture(URL picture) {
		this.picture = picture;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	public static Mobile getFullObjectInstance() {
		return new Mobile(new Hardware(), new Release());
	}

}
