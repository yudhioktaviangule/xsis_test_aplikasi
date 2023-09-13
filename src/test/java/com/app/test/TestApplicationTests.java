package com.app.test;

import com.app.test.app.entities.Film;
import com.app.test.app.services.implementations.MovieServiceImplementation;
import com.app.test.app.services.interfaces.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
@AutoConfigureMockMvc
class TestApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@Test
	void testGetMovie()throws Exception{
		mockMvc.perform(get("api/v1/master/movies"))
				.andExpect(status().isOk());
	}


}
