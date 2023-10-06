package com.das.consultation.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJS
 * @Date: 2023/3/5 19:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectProgressVO {

    /**
     * 阶段名称
     */
    private String nodeName;

    /**
     * 计划完成周期（YYYY-MM）
     */
    private String planDate;

    /**
     * 状态（0-未完成；1-完成；2-延期）
     */
    private Integer status;

    /**
     * 阶段详情
     */
    private String info;

}
