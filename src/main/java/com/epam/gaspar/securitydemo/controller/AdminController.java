package com.epam.gaspar.securitydemo.controller;

import com.epam.gaspar.securitydemo.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final DataService dataService;

    @DeleteMapping("/delete-all-data")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteAllData() {
        log.warn("Danger: admin call was made to delete all data");
        dataService.deleteAllData();
    }

}
