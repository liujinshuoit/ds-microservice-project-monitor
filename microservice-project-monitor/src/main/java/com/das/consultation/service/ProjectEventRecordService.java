package com.das.consultation.service;

import com.das.consultation.entities.dto.ProjectEventOverviewDTO;
import com.das.consultation.entities.dto.ProjectEventRecordDTO;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface ProjectEventRecordService {

    int insertList(List<ProjectEventRecordDTO> projectEventRecordDTOList);

    int delete(String projectCode);

    List<ProjectEventOverviewDTO> getProjectEventOverviewList(int type);

}
