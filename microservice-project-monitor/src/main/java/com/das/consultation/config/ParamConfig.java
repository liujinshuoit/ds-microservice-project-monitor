package com.das.consultation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by LJS on 2022/2/9.
 */
@Component("ParamConfig")
public class ParamConfig {

    @Value("${project.oppm.url:http://localhost:8888/image/}")
    private String oppmImageUrl;


    public String getOppmImageUrl() {
        return oppmImageUrl;
    }

    public void setOppmImageUrl(String oppmImageUrl) {
        this.oppmImageUrl = oppmImageUrl;
    }
}
