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
public class PersonDTO {

    /**
     * 自增主键
     */
    private int id;

    /**
     * 人员编号（公司员工编号）
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
     * 当前所在项目编号
     */
    private String currentProjectCode;

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
