package com.das.consultation.enums;

/**
 * @Author: LJS
 * @Date: 2023/3/7 15:19
 */
public enum PersonPositionEnum {

    XMJL(1, "项目经理"),
    PTGCS(2, "平台工程师"),
    JKKFGCS(3, "接口开发工程师"),
    SJCJGCS(4, "数据采集工程师"),
    SSGCS(5, "实施工程师"),
    WLGCS(6, "网络工程师"),
    DBA(7, "DBA"),
    OTHER(99, "其它");

    private Integer positionCode;

    private String positionName;

    PersonPositionEnum(Integer positionCode, String positionName) {
        this.positionCode = positionCode;
        this.positionName = positionName;
    }

    public Integer getPositionCode() {
        return positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public static Integer getPositionCode(String statusName) {
        for (PersonPositionEnum projectEnum : PersonPositionEnum.values()) {
            if (statusName.equals(projectEnum.getPositionName())){
                return projectEnum.getPositionCode();
            } else {
                return OTHER.getPositionCode();
            }
        }
        return null;
    }

}
