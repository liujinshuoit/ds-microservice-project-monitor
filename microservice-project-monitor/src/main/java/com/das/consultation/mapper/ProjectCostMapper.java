package com.das.consultation.mapper;

import com.das.consultation.entities.dto.ProjectCostDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: LJS
 * @Date: 2022/1/26 15:45
 */
@Mapper
public interface ProjectCostMapper {

    int insert(ProjectCostDTO projectCostDTO);

    int delete(String projectCode);

    int update(ProjectCostDTO projectCostDTO);

}
