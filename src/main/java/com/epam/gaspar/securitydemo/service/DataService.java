package com.epam.gaspar.securitydemo.service;

import com.epam.gaspar.securitydemo.error.DataNotFoundException;
import com.epam.gaspar.securitydemo.repo.Data;
import com.epam.gaspar.securitydemo.repo.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;

    public Data getDataById(long id) {
        return dataRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
    }

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    public Data saveData(Data data) {
        Data savedData = dataRepository.save(data);
        log.info("New data was saved: {}", savedData);
        return savedData;
    }

    public void deleteAllData() {
        dataRepository.deleteAll();
        log.warn("All data was deleted");
    }

    public long countData() {
        return dataRepository.count();
    }

}
