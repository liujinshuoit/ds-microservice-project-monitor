package com.das.consultation.entities.param;

import lombok.Data;

/**
 * @Author: LJS
 * @Date: 2022/7/12 15:23
 */
@Data
public class OrgDateQueryParam {

    /**
     * 日期
     */
    private String date;

    /**
     * 机构号
     */
    private String orgCode;

}
