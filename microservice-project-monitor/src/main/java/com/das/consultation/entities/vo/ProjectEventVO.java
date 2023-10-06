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
public class ProjectEventVO {

    /**
     * 事项名称
     */
    private String eventName;

    /**
     * 事项日期（YYYY-MM-DD）
     */
    private String eventDate;

}
