package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.ProjectEventOverviewDTO;
import com.das.consultation.entities.dto.ProjectEventRecordDTO;
import com.das.consultation.mapper.ProjectEventRecordMapper;
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
public class ProjectEventRecordServiceImpl implements ProjectEventRecordService {

    private Logger logger = LoggerFactory.getLogger(ProjectEventRecordServiceImpl.class);

    @Resource
    private ProjectEventRecordMapper projectEventRecordMapper;

    @Override
    public int insertList(List<ProjectEventRecordDTO> projectEventRecordDTOList) {
        return projectEventRecordMapper.insertList(projectEventRecordDTOList);
    }

    @Override
    public int delete(String projectCode) {
        return projectEventRecordMapper.delete(projectCode);
    }

    @Override
    public List<ProjectEventOverviewDTO> getProjectEventOverviewList(int type) {
        return projectEventRecordMapper.getProjectEventOverviewList(type);
    }
}
