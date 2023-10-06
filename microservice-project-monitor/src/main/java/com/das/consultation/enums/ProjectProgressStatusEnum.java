package com.das.consultation.enums;

/**
 * @Author: LJS
 * @Date: 2023/3/7 15:19
 */
public enum ProjectProgressStatusEnum {

    INCOMPLETE(0, "未完成"),
    COMPLETE(1, "已完成"),
    DELAY(2, "已延期");

    private Integer statusCode;

    private String statusName;

    ProjectProgressStatusEnum(Integer statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public static Integer getStatusCode(String statusName) {
        for(ProjectProgressStatusEnum projectEnum : ProjectProgressStatusEnum.values()) {
            if(statusName.equals(projectEnum.getStatusName())){
                return projectEnum.getStatusCode();
            }
        }
        return null;
    }

}
