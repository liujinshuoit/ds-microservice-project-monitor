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
public class ProjectEventRecordDTO {

    /**
     * 自增主键
     */
    private int id;

    /**
     * 事项名称
     */
    private String eventName;

    /**
    * 事项日期（YYYY-MM-DD）
    */
    private Date eventDate;

    /**
     * 事项类型（1-重大事项；2-客户投诉与嘉奖）
     */
    private int type;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 状态（0-删除；1-正常）
     */
    private int state;

    /**
     * 更新时间
     */
    private Date updateTime;

}
