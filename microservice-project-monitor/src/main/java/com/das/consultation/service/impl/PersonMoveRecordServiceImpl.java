package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.PersonMoveRecordDTO;
import com.das.consultation.entities.dto.ProjectEventRecordDTO;
import com.das.consultation.entities.dto.ProjectPersonMoveOverviewDTO;
import com.das.consultation.mapper.PersonMoveRecordMapper;
import com.das.consultation.mapper.ProjectEventRecordMapper;
import com.das.consultation.service.PersonMoveRecordService;
import com.das.consultation.service.ProjectEventRecordService;
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
public class PersonMoveRecordServiceImpl implements PersonMoveRecordService {

    private Logger logger = LoggerFactory.getLogger(PersonMoveRecordServiceImpl.class);

    @Resource
    private PersonMoveRecordMapper personMoveRecordMapper;

    @Override
    public int insertList(List<PersonMoveRecordDTO> personMoveRecordDTOList) {
        return personMoveRecordMapper.insertList(personMoveRecordDTOList);
    }

    @Override
    public int delete(String projectCode) {
        return personMoveRecordMapper.delete(projectCode);
    }

    @Override
    public List<ProjectPersonMoveOverviewDTO> getProjectPersonMoveOverviewList() {
        return personMoveRecordMapper.getProjectPersonMoveOverviewList();
    }
}
