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
public class PersonMoveVO {

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
    private String startDate;

    /**
     * 支援结束日期（YYYY-MM-DD）
     */
    private String endDate;

    /**
     * 支援事由
     */
    private String supportInfo;

}
