package com.das.consultation.filter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: LJS
 * @Date: 2022/7/13 9:56
 * <p>Title: ConfigInterceptor.java</p>
 * <p>Description:跨域过滤器，解决跨域问题 </p>
 * @author youthMing
 * @date 2020年5月21日
 */
@Component
public class CorsFilter implements Filter {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

//        HttpServletResponse response = (HttpServletResponse) resp;
//        HttpServletRequest request = (HttpServletRequest) req;
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        // 这里“Access-Token”是我要传到后台的内容key
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
//        response.setHeader("Access-Control-Expose-Headers", "*");
        chain.doFilter(req, resp);

    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}

