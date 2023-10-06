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
public class ProjectEventOverviewDTO {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 事项名称
     */
    private String eventName;

    /**
     * 事项日期（YYYY-MM-DD）
     */
    private Date eventDate;

}
