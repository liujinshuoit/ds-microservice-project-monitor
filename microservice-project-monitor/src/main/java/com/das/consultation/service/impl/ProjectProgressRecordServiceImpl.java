package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.ProjectProgressOverviewDTO;
import com.das.consultation.entities.dto.ProjectProgressRecordDTO;
import com.das.consultation.mapper.ProjectProgressRecordMapper;
import com.das.consultation.service.ProjectProgressRecordService;
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
public class ProjectProgressRecordServiceImpl implements ProjectProgressRecordService {

    private Logger logger = LoggerFactory.getLogger(ProjectProgressRecordServiceImpl.class);

    @Resource
    private ProjectProgressRecordMapper projectProgressRecordMapper;

    @Override
    public int insertList(List<ProjectProgressRecordDTO> projectProgressRecordDTOList) {
        return projectProgressRecordMapper.insertList(projectProgressRecordDTOList);
    }

    @Override
    public int delete(String projectCode) {
        return projectProgressRecordMapper.delete(projectCode);
    }

    @Override
    public List<ProjectProgressOverviewDTO> getProjectProgressOverviewList() {
        return projectProgressRecordMapper.getProjectProgressOverviewList();
    }
}
