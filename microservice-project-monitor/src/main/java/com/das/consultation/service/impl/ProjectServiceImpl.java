package com.das.consultation.service.impl;

import com.das.consultation.entities.dto.ProjectDTO;
import com.das.consultation.entities.dto.ProjectOverviewDetailDTO;
import com.das.consultation.entities.dto.ProjectPersonOverviewDTO;
import com.das.consultation.mapper.ProjectMapper;
import com.das.consultation.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public int insert(ProjectDTO projectDTO) {
        return projectMapper.insert(projectDTO);
    }

    @Override
    public int delete(String projectCode) {
        return projectMapper.delete(projectCode);
    }

    @Override
    public ProjectDTO selectOne(String projectCode) {
        return projectMapper.selectOne(projectCode);
    }

    @Override
    public List<ProjectPersonOverviewDTO> getProjectPersonOverviewList() {
        return projectMapper.getProjectPersonOverviewList();
    }

    @Override
    public List<ProjectOverviewDetailDTO> getProjectOverviewDetailList() {
        return projectMapper.getProjectOverviewDetailList();
    }
}
