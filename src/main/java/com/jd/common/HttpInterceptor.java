package com.jd.common;

import com.jd.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by admin360buyad on 2018/4/5.
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI().toString();
        Map paramMap = request.getParameterMap();
        log.info("request start. uri:{}, params:{}", uri, JsonMapper.obj2String(paramMap));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uri = request.getRequestURI().toString();
        Map paramMap = request.getParameterMap();
        log.info("request finish. uri:{}, params:{}", uri, JsonMapper.obj2String(paramMap));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI().toString();
        Map paramMap = request.getParameterMap();
        log.info("request exception. uri:{}, params:{}", uri, JsonMapper.obj2String(paramMap));
    }
}
