package com.das.consultation.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: LJS
 * @Date: 2022/7/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectOverviewVO {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目人数
     */
    private Integer personNumber;

    /**
     * 项目进度集合
     */
    private List<ProjectProgressVO> progressList;

    /**
     * 人员动向集合
     */
    private List<PersonMoveVO> moveList;

    /**
     * 项目重大事项集合
     */
    private List<ProjectEventVO> eventList;

}
