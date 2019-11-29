package com.ht.interceptor;

import com.ht.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/26.
 */
public class MyInterceptor implements HandlerInterceptor {
    //白名单
    private static String [] urls = {"/emp/login","/emp/register"};
    /**
     * 进入到控制器方法前
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("当前请求路径: "+httpServletRequest.getRequestURI());
        System.out.println("当前请求路径: "+httpServletRequest.getServletPath());
        System.out.println("方法执行前： "+new Date().toLocaleString());
        System.out.println("控制器类："+o.getClass().getName()+" "+o.getClass().getCanonicalName()+" "+o.getClass().getSimpleName());

        String path = httpServletRequest.getRequestURI();//当前请求路径
        for(String s : urls){
            if(s.equals(path)){
                return true;
            }
        }

        HttpSession session =  httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){//表示没有登录
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
        }
        return true;//表示登录了
    }

    /**
     * 进入控制器方法后，视图渲染前
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求完成后，视图渲染结束后
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
