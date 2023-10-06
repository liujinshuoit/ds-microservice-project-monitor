package com.das.consultation.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJS
 * @Date: 2022/7/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectOverviewDetailDTO {

    /**
    * 项目名称
    */
    private String projectName;

    /**
     * 计划成本（万）
     */
    private double planCost;

    /**
     * 已发生成本（万）
     */
    private double occurredCost;

}
