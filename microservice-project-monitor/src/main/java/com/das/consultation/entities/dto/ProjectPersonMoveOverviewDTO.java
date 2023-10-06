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
public class ProjectPersonMoveOverviewDTO {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 人员姓名
     */
    private String personName;

    /**
     * 支援项目名称
     */
    private String supportProjectName;

    /**
     * 支援开始日期（YYYY-MM-DD）
     */
    private Date startDate;

    /**
     * 支援结束日期（YYYY-MM-DD）
     */
    private Date endDate;

    /**
     * 支援事由
     */
    private String supportInfo;

}
