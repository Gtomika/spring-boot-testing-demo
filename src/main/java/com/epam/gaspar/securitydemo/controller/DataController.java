package com.epam.gaspar.securitydemo.controller;

import com.epam.gaspar.securitydemo.controller.dto.DataCreationRequest;
import com.epam.gaspar.securitydemo.controller.dto.DataResponse;
import com.epam.gaspar.securitydemo.mapper.DataMapper;
import com.epam.gaspar.securitydemo.repo.Data;
import com.epam.gaspar.securitydemo.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;
    private final DataMapper dataMapper;

    @GetMapping
    public List<DataResponse> getAllData() {
        return dataMapper.map(dataService.getAllData());
    }

    @GetMapping("/{id}")
    public DataResponse getDataById(@PathVariable Long id) {
        return dataMapper.map(dataService.getDataById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DataResponse createData(@RequestBody DataCreationRequest dataCreationRequest) {
        Data preSavedData = dataMapper.map(dataCreationRequest);
        return dataMapper.map(dataService.saveData(preSavedData));
    }

}
