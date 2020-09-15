package com.axiom.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.api.entity.Mobile;
import com.axiom.api.exception.ApiException;
import com.axiom.api.model.Response;
import com.axiom.api.services.SearchService;
import com.axiom.api.util.Constants;

@RestController
@RequestMapping(Constants.MOBILE_API_URL)
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping(Constants.SEARCH_API_URL)
	public Response searchMobile(HttpServletRequest request, @RequestParam Map<String, String> search)
			throws ApiException {
		// To make Search Service Generic we will pass Device object from controller
		return (Response) searchService.getAvailableMobile(search, Mobile.getFullObjectInstance());
	}
}
