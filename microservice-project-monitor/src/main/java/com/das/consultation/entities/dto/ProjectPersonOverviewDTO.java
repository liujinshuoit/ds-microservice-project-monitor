package com.das.consultation.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJS
 * @Date: 2022/7/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPersonOverviewDTO {

    /**
    * 项目名称
    */
    private String projectName;

    /**
     * 项目人数
     */
    private int personNumber;

}
