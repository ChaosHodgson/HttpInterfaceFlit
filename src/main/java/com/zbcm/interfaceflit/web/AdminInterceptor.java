package com.zbcm.interfaceflit.web;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ChaosWang on 2016/07/28.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    private List<String> ignoreUris;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean notIntercept = false;

        String uri = request.getRequestURI();
        for (String ignoreUri: ignoreUris){
            if (uri.equals(ignoreUri)){
                notIntercept = true;
                break;
            }
        }



        return notIntercept;
    }

    public void setIgnoreUris(List<String> ignoreUris){
        this.ignoreUris = ignoreUris;
    }

}
