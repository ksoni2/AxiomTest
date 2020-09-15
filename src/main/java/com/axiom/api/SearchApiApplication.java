package com.axiom.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import com.axiom.api.entity.Hardware;
import com.axiom.api.entity.Mobile;
import com.axiom.api.entity.Release;
import com.axiom.api.repository.MobilesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class SearchApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(SearchApiApplication.class);
	
	@Autowired
	  private MobilesRepository mobilesRepository;
	
	@Autowired
	ResourceLoader resourceLoader;


	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		return mapper;
	}
	

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			logger.info("Calling RestApi to get Devices List");
			seedData();
			
			logger.info("Device List loaded in DB");
		};
	}
	 private void seedData() throws MalformedURLException, Exception, JsonProcessingException {
		      
		    String jsonArray="" ;
		    
		    Resource resource = resourceLoader.getResource("classpath:Mobile_database.json");
		    InputStream inputStream = resource.getInputStream();
		 
		    try
		    {
		        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
		        jsonArray = new String(bdata, StandardCharsets.UTF_8);
		        logger.info(jsonArray);
		    } 
		    catch (IOException e) 
		    {
		        logger.error("IOException", e);
		    }

		    ObjectMapper objectMapper = new ObjectMapper();

		    Mobile[] mobiles = objectMapper.readValue(jsonArray, Mobile[].class);
		    for (Mobile mobile : mobiles) {
		    	mobilesRepository.save(mobile);
			}
		   
		  }

}
