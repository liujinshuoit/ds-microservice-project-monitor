package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.PersonDTO;
import com.das.consultation.mapper.PersonMapper;
import com.das.consultation.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 16:12
 */
@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Resource
    private PersonMapper personMapper;

    @Override
    public int insertList(List<PersonDTO> personDTOList) {
        return personMapper.insertList(personDTOList);
    }

    @Override
    public int delete(String projectCode) {
        return personMapper.delete(projectCode);
    }

}
