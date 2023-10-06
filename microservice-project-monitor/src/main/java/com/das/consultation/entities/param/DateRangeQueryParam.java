package com.das.consultation.entities.param;

import lombok.Data;

/**
 * @Author: LJS
 * @Date: 2022/7/12 15:23
 */
@Data
public class DateRangeQueryParam {

    /**
     * 日期
     */
    private String startDate;

    /**
     * 日期
     */
    private String endDate;

}
