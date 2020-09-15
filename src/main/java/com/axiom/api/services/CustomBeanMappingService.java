/**
 * 
 */
package com.axiom.api.services;

import java.util.Map;

import com.axiom.api.exception.ApiException;


@FunctionalInterface
public interface CustomBeanMappingService {

	public <T> T prepareObjectForSearch(Map<String, String> requestedKeys, T t) throws ApiException;
}
