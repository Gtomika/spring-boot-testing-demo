package com.epam.gaspar.securitydemo.service;

import com.epam.gaspar.securitydemo.error.DataNotFoundException;
import com.epam.gaspar.securitydemo.repo.Data;
import com.epam.gaspar.securitydemo.repo.DataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataServiceTest {

    @Mock
    private DataRepository dataRepository;

    private DataService dataService;

    @BeforeEach
    public void setUp() {
        dataService = new DataService(dataRepository);
    }

    @Test
    public void shouldFindDataById() {
        Data testData = createTestData();
        Mockito.when(dataRepository.findById(testData.getId())).thenReturn(Optional.of(testData));

        Data actualData = dataService.getDataById(testData.getId());
        assertEquals(testData, actualData);
    }

    @Test
    public void shouldNotFindDataById() {
        Data testData = createTestData();
        Mockito.when(dataRepository.findById(testData.getId())).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> dataService.getDataById(testData.getId()));
    }

    //TODO: add more unit tests

    private Data createTestData() {
        return Data.builder()
                .id(1L)
                .key("unit")
                .value("test")
                .createTimestamp(Instant.now())
                .build();
    }

}