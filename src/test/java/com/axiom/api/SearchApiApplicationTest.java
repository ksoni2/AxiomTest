package com.axiom.api;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.axiom.api.SearchApiApplication;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = SearchApiApplication.class)
public class SearchApiApplicationTest {

	@Test
	public void contextLoads() {
		
	}
}
