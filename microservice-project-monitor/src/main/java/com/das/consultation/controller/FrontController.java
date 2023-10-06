package com.das.consultation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端页面控制器
 * @Author: LJS
 * @Date: 2022/7/11 15:10
 */
@Controller
public class FrontController {

    /**
     * 首页页面控制器
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 测试页面控制器
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
