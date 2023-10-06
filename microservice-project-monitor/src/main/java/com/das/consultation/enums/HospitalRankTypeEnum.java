package com.das.consultation.enums;

import lombok.Getter;

/**
 * @Author: LJS
 * @Date: 2022/7/14 9:43
 */
@Getter
public enum HospitalRankTypeEnum {

    SCORE("医疗机构"), RANK("排名");

    private final String typeName;

    HospitalRankTypeEnum(String typeName) {
        this.typeName = typeName;
    }

}
