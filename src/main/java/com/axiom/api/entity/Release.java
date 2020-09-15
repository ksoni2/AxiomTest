package com.axiom.api.entity;

import java.io.Serializable;

public class Release implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String announceDate;
	private Double priceEur;
	
	public Release() {}

	public Release(String announceDate, Double priceEur) {
		super();
		this.announceDate = announceDate;
		this.priceEur = priceEur;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public Double getPriceEur() {
		return priceEur;
	}

	public void setPriceEur(Double priceEur) {
		this.priceEur = priceEur;
	}

}
