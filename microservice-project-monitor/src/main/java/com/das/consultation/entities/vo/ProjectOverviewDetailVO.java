package com.das.consultation.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/7/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectOverviewDetailVO {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 计划成本（万）
     */
    private double planCost;

    /**
     * 已发生成本（万）
     */
    private double occurredCost;

    /**
     * 项目重大事项集合
     */
    private List<ProjectEventVO> event;

}
