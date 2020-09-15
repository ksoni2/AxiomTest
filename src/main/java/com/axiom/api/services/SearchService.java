package com.axiom.api.services;

import java.util.Map;

import com.axiom.api.exception.ApiException;

@FunctionalInterface
public interface SearchService {

	public <T> Object getAvailableMobile(Map<String, String> requestKeys, T t) throws ApiException;

}
