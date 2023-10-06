package com.das.consultation.enums;

/**
 * @Author: LJS
 * @Date: 2023/3/7 15:19
 */
public enum ProjectEnum {

    PMO("PMO", "PMO", "PMO", 0),
    SZXM("SZXM", "宿州项目", "宿州", 1),
    FLXM("FLXM", "涪陵项目", "涪陵", 2),
    HSXM("HSXM", "衡水项目", "衡水", 3),
    BAXM("BAXM", "宝安项目", "宝安", 4),
    HLXYY("HLXYY", "哈励逊医院", "哈院", 5),
    HNXM("HNXM", "淮南项目", "淮南", 11),
    BDXM("BDXM", "保定项目", "保定", 7),
    TJYY("TJYY", "桃江医院", "桃江", 8),
    ZYYY("ZYYY", "遵医医院", "遵医", 9),
    HLXM("HLXM", "华疗项目", "华疗", 10),
    FYXM("FYXM", "阜阳项目", "阜阳", 6);

    private String projectCode;

    private String projectName;

    private String projectShortName;

    private Integer projectSort;

    ProjectEnum(String projectCode, String projectName, String projectShortName, Integer projectSort) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.projectShortName = projectShortName;
        this.projectSort = projectSort;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectShortName() {
        return projectShortName;
    }

    public Integer getProjectSort() {
        return projectSort;
    }

    public static String getProjectCode(String projectName) {
        for(ProjectEnum projectEnum : ProjectEnum.values()) {
            if(projectName.equals(projectEnum.getProjectName())){
                return projectEnum.getProjectCode();
            }
        }
        return null;
    }

    public static String getProjectCodeByShortName(String projectShortName) {
        for(ProjectEnum projectEnum : ProjectEnum.values()) {
            if(projectShortName.equals(projectEnum.getProjectShortName())){
                return projectEnum.getProjectCode();
            }
        }
        return null;
    }

    public static String getProjectShortName(String projectName) {
        for(ProjectEnum projectEnum : ProjectEnum.values()) {
            if(projectName.equals(projectEnum.getProjectName())){
                return projectEnum.getProjectShortName();
            }
        }
        return null;
    }

    public static Integer getProjectSort(String projectName) {
        for(ProjectEnum projectEnum : ProjectEnum.values()) {
            if(projectName.equals(projectEnum.getProjectName())){
                return projectEnum.getProjectSort();
            }
        }
        return null;
    }

}
