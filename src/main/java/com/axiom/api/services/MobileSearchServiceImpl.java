package com.axiom.api.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.axiom.api.entity.Mobile;
import com.axiom.api.exception.ApiException;
import com.axiom.api.model.Response;
import com.axiom.api.repository.MobilesRepository;
import com.axiom.api.util.Constants;
import com.axiom.api.util.ErrorConstants;


@Service
public class MobileSearchServiceImpl implements SearchService {

	private static final Logger logger = LoggerFactory.getLogger(MobileSearchServiceImpl.class);

	@Autowired
	private MobilesRepository mobilesRepository;

	@Autowired
	private CustomBeanMappingService customBeanMappingService;

	@Override
	public <T> Object getAvailableMobile(Map<String, String> requestKeys, T t) throws ApiException {
		Response response = new Response();
		logger.info("<----------------Enter getAvailableMobile|MobileSearchServiceImpl---------------->");
		try {
			Mobile mobile = (Mobile) customBeanMappingService.prepareObjectForSearch(requestKeys, t);
			List<Mobile> deviceList = mobilesRepository.findAll(Example.of(mobile, ExampleMatcher.matchingAll()
					.withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)));
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setDevices(deviceList);
		} catch (Exception e) {
			logger.error("Exception in MobileSearchServiceImpl|getAvailableDevice:{}", e);
			throw new ApiException(ErrorConstants.INTERNAL_ERROR);
		}
		logger.info("<----------------Exit getAvailableMobile|MobileSearchServiceImpl---------------->");
		return response;
	}
}
