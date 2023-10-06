package com.das.consultation.entities.param;

import lombok.Data;

/**
 * @Author: LJS
 * @Date: 2022/7/12 15:23
 */
@Data
public class OrgDateRangeQueryParam {

    /**
     * 日期
     */
    private String startDate;

    /**
     * 日期
     */
    private String endDate;

    /**
     * 机构号
     */
    private String orgCode;

}
