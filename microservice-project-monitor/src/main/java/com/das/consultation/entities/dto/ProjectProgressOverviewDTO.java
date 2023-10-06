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
public class ProjectProgressOverviewDTO {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 阶段名称
     */
    private String nodeName;

    /**
    * 计划完成周期（YYYY-MM）
    */
    private Date planDate;

    /**
     * 状态（0-未完成；1-完成；2-延期）
     */
    private int status;

    /**
     * 阶段详情
     */
    private String info;

}
