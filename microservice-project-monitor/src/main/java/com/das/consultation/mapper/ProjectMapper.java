package com.das.consultation.mapper;

import com.das.consultation.entities.dto.ProjectDTO;
import com.das.consultation.entities.dto.ProjectOverviewDetailDTO;
import com.das.consultation.entities.dto.ProjectPersonOverviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface ProjectMapper {

    int insert(ProjectDTO projectDTO);

    int delete(String projectCode);

    ProjectDTO selectOne(@Param("projectCode") String projectCode);

    List<ProjectPersonOverviewDTO> getProjectPersonOverviewList();

    List<ProjectOverviewDetailDTO> getProjectOverviewDetailList();

}
