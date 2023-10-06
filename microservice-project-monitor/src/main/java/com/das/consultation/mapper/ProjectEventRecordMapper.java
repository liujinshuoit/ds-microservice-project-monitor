package com.das.consultation.mapper;

import com.das.consultation.entities.dto.ProjectEventOverviewDTO;
import com.das.consultation.entities.dto.ProjectEventRecordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface ProjectEventRecordMapper {

    int insertList(@Param("projectEventRecordDTOList") List<ProjectEventRecordDTO> projectEventRecordDTOList);

    int delete(String projectCode);

    List<ProjectEventOverviewDTO> getProjectEventOverviewList(@Param("type") int type);

}
