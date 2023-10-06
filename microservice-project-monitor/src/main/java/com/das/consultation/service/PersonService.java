package com.das.consultation.service;

import com.das.consultation.entities.dto.PersonDTO;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface PersonService {

    int insertList(List<PersonDTO> personDTOList);

    int delete(String projectCode);

}
