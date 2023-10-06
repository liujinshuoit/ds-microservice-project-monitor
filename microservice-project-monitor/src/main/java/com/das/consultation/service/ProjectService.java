package com.das.consultation.service;

import com.das.consultation.entities.dto.ProjectDTO;
import com.das.consultation.entities.dto.ProjectOverviewDetailDTO;
import com.das.consultation.entities.dto.ProjectPersonOverviewDTO;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface ProjectService {

    /**
     * 项目存储
     * @return
     */
    int insert(ProjectDTO projectDTO);

    int delete(String projectCode);

    ProjectDTO selectOne(String projectCode);

    List<ProjectPersonOverviewDTO> getProjectPersonOverviewList();

    List<ProjectOverviewDetailDTO> getProjectOverviewDetailList();

}
