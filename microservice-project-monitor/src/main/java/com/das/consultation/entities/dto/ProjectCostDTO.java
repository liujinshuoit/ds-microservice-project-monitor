package com.das.consultation.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LJS
 * @Date: 2022/7/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCostDTO {

    /**
     * 自增主键
     */
    private int id;

    /**
     * 计划成本（万）
     */
    private double planCost;

    /**
    * 已发生成本（万）
    */
    private double occurredCost;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 数据版本号
     */
    private int version;

    /**
     * 状态（0-删除；1-正常）
     */
    private int state;

    /**
     * 更新时间
     */
    private Date updateTime;

}
