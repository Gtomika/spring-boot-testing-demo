package com.epam.gaspar.securitydemo.controller;

import com.epam.gaspar.securitydemo.TestcontainersSetup;
import com.epam.gaspar.securitydemo.repo.Data;
import com.epam.gaspar.securitydemo.repo.DataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerIntegrationTest extends TestcontainersSetup {

    private static final Data TEST_DATA_1 = Data.of("key1", "something1");
    private static final Data TEST_DATA_2 = Data.of("key2", "something2");
    private static final String DATA_PATH = "/data";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter objectMapperConverter;

    @BeforeEach
    public void setUp() {
        dataRepository.saveAll(List.of(TEST_DATA_1, TEST_DATA_2));
    }

    @AfterEach
    public void tearDown() {
        dataRepository.deleteAll();
    }

    @Test
    public void shouldGetAllData() throws Exception {
        String expectedBody = objectMapperConverter.getObjectMapper()
                .writeValueAsString(dataRepository.findAll());

        mockMvc.perform(get(DATA_PATH))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedBody));
    }

    @Test
    public void shouldGetDataById() throws Exception {
        Data expectedData = dataRepository.findAll().stream()
                .findAny()
                .orElseThrow();
        String expectedDataJson = objectMapperConverter.getObjectMapper()
                .writeValueAsString(expectedData);

        mockMvc.perform(get(DATA_PATH + "/" + expectedData.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedDataJson));
    }

    @Test
    public void shouldNotGetDataByIdWhenIdDoesNotExist() throws Exception {
        long nonExistentId = 984819418L;
        mockMvc.perform(get(DATA_PATH + "/" + nonExistentId))
                .andExpect(status().isNotFound());
                //TODO could test error response body as well
    }

    //TODO add more integration tests for the other data endpoints

}
