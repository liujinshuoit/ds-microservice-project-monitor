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
public class PersonMoveRecordDTO {

    /**
     * 自增主键
     */
    private int id;

    /**
     * 人员编号
     */
    private String personCode;

    /**
     * 人员姓名
     */
    private String personName;

    /**
     * 1-项目经理；2-平台工程师；3-接口开发工程师；4-数据采集工程师；5-实施工程师；6-网络工程师；7-DBA
     */
    private int position;

    /**
    * BASE项目编号
    */
    private String baseProjectCode;

    /**
     * BASE项目名称
     */
    private String baseProjectName;

    /**
     * 支援项目编号
     */
    private String supportProjectCode;

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

    /**
     * 状态（0-删除；1-正常）
     */
    private int state;

    /**
     * 更新时间
     */
    private Date updateTime;

}
