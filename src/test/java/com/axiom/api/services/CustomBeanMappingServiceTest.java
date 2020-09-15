package com.axiom.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.axiom.api.SearchApiApplicationTest;
import com.axiom.api.entity.Hardware;
import com.axiom.api.exception.ApiException;
import com.axiom.api.services.CustomBeanMappingService;


public class CustomBeanMappingServiceTest extends SearchApiApplicationTest {

	@Autowired
	CustomBeanMappingService customBeanMappingService;

	@Test
	@DisplayName("Test Key Value to Object Mapping")
	public void testMappingService() throws ApiException {
		Hardware hardware = new Hardware();
		Map<String, String> map = Maps.newHashMap("audioJack", "3AA");
		Hardware response = customBeanMappingService.prepareObjectForSearch(map, hardware);
		assertNotNull(response);
		assertEquals("3AA", response.getAudioJack());
	}

	@Test
	@DisplayName("Test Object Mapping Exception")
	public void testMappingServiceException() throws ApiException {
		assertThrows(ApiException.class, () -> {
			List<Hardware> hardware = new ArrayList<>();
			Map<String, String> map = Maps.newHashMap("audioJack", "3AA");
			customBeanMappingService.prepareObjectForSearch(map, hardware);
		});

	}
}
