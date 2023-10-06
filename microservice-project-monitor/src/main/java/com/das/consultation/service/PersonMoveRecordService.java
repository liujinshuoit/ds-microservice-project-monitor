package com.das.consultation.service;

import com.das.consultation.entities.dto.PersonMoveRecordDTO;
import com.das.consultation.entities.dto.ProjectPersonMoveOverviewDTO;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface PersonMoveRecordService {

    int insertList(List<PersonMoveRecordDTO> personMoveRecordDTOList);

    int delete(String projectCode);

    List<ProjectPersonMoveOverviewDTO> getProjectPersonMoveOverviewList();

}
