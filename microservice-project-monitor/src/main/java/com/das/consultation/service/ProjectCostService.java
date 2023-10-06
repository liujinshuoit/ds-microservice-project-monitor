package com.das.consultation.service;

import com.das.consultation.entities.dto.ProjectCostDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: LJS
 * @Date: 2023/3/1 16:12
 */
public interface ProjectCostService {

    /**
     * 项目存储
     * @return
     */
    int insert(ProjectCostDTO projectCostDTO);

    int delete(String projectCode);

    int updateByCode(@Param("projectCode") String projectCode);

}
