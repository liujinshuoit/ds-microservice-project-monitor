package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.ProjectCostDTO;
import com.das.consultation.mapper.ProjectCostMapper;
import com.das.consultation.service.ProjectCostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LJS
 * @Date: 2022/1/26 16:12
 */
@Service
public class ProjectCostServiceImpl implements ProjectCostService {

    private Logger logger = LoggerFactory.getLogger(ProjectCostServiceImpl.class);

    @Resource
    private ProjectCostMapper projectCostMapper;

    @Override
    public int insert(ProjectCostDTO projectCostDTO) {
        return projectCostMapper.insert(projectCostDTO);
    }

    @Override
    public int delete(String projectCode) {
        return projectCostMapper.delete(projectCode);
    }

    @Override
    public int updateByCode(String projectCode) {
        return 0;
    }
}
