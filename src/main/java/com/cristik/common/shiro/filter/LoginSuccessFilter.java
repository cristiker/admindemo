package com.cristik.common.shiro.filter;

import com.cristik.common.base.Result;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by zhenghua on 2016/5/3.
 */
public class LoginSuccessFilter extends FormAuthenticationFilter {

    private static Logger logger = Logger.getLogger(LoginSuccessFilter.class);

    @Autowired
    SessionDAO sessionDAO;

    /**
     * ajax请求返回json数据不返回页面
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {// 不是ajax请求
            issueSuccessRedirect(request, response);
        } else {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            Result result = new Result(true);
            result.setMsg("登陆成功");
            writer.write(result.toString());
            writer.flush();
            writer.close();
        }
        return false;
    }

    /*private void kickOther(AuthenticationToken token,Subject subject){

        Session currentSession = null;

        Collection<Session> sessions = sessionDAO.getActiveSessions();

        for(Session session:sessions){

            if(loginName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY))) {

                session.setTimeout(0);//设置session立即失效，即将其踢出系统

                break;

            }

        }
    }*/


}
