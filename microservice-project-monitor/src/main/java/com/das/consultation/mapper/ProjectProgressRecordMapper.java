package com.das.consultation.mapper;

import com.das.consultation.entities.dto.ProjectProgressOverviewDTO;
import com.das.consultation.entities.dto.ProjectProgressRecordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface ProjectProgressRecordMapper {

    int insertList(@Param("projectProgressRecordDTOList") List<ProjectProgressRecordDTO> projectProgressRecordDTOList);

    int delete(String projectCode);

    int delete(@Param("personMoveRecordDTOList") List<ProjectProgressRecordDTO> projectProgressRecordDTOList);

    List<ProjectProgressOverviewDTO> getProjectProgressOverviewList();

}
