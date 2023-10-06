package com.das.consultation.service;

import com.das.consultation.entities.dto.ProjectProgressOverviewDTO;
import com.das.consultation.entities.dto.ProjectProgressRecordDTO;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface ProjectProgressRecordService {

    int insertList(List<ProjectProgressRecordDTO> projectProgressRecordDTOList);

    int delete(String projectCode);

    List<ProjectProgressOverviewDTO> getProjectProgressOverviewList();

}
