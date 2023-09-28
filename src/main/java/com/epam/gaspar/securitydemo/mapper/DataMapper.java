package com.epam.gaspar.securitydemo.mapper;

import com.epam.gaspar.securitydemo.controller.dto.DataCreationRequest;
import com.epam.gaspar.securitydemo.controller.dto.DataResponse;
import com.epam.gaspar.securitydemo.repo.Data;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DataMapper {

    DataResponse map(Data data);

    List<DataResponse> map(List<Data> dataList);

    Data map(DataCreationRequest dataCreationRequest);

}
