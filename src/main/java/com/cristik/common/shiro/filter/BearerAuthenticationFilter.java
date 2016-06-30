package com.cristik.common.shiro.filter;

import com.cristik.common.base.JSONResult;
import com.cristik.common.base.StatusCode;
import com.cristik.common.shiro.token.BearerHeaderToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by zhenghua on 2016/5/30.
 */
public class BearerAuthenticationFilter extends AuthenticatingFilter{

    public static final String DEFAULT_ERROR_KEY_ATTRIBUTE_NAME = "shiroLoginFailure";

    protected static final String AUTHORIZATION_HEADER = "Authorization";

    //protected static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private String failureKeyAttribute = DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String authorizationHeader  = httpServletRequest.getHeader("Authorization");
        if(authorizationHeader == null || authorizationHeader.length() == 0){
            return createToken("", "", request, response);
        }else{
            if(authorizationHeader.toLowerCase().startsWith("basic")){
                String[] prinCred = getPrincipalsAndCredentials(authorizationHeader, request);
                if (prinCred == null || prinCred.length < 2) {
                    // Create an authentication token with an empty password,
                    // since one hasn't been provided in the request.
                    String username = prinCred == null || prinCred.length == 0 ? "" : prinCred[0];
                    return createToken(username, "", request, response);
                }
                String username = prinCred[0];
                String password = prinCred[1];
                request.setAttribute("loginName",username);
                return createToken(username, password, request, response);
            }else if(authorizationHeader.toLowerCase().startsWith("bearer")){
                String token = authorizationHeader.substring(7);
                return createToken(token);
            }else{
                return createToken("", "", request, response);
            }
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean loggedIn = false;
        if (isLoginAttempt(request, response)) {
            loggedIn = executeLogin(request, response);
        }
        if (!loggedIn) {
            sendChallenge(request, response);
        }
        return loggedIn;
    }

    protected AuthenticationToken createToken(String token){
        return new BearerHeaderToken(token);
    }

    protected boolean isLoginAttempt(ServletRequest request,ServletResponse response){
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String url = httpRequest.getRequestURI();
        String application = httpRequest.getContextPath();
        return url.startsWith(application+"/api");
        /*String authzHeader = getAuthzHeader(request);
        return authzHeader!=null && isLoginAttempt(authzHeader);*/
    }

    protected boolean isLoginAttempt(String authzHeader){
        return authzHeader.toLowerCase(Locale.ENGLISH).startsWith("basic")||authzHeader.toLowerCase(Locale.ENGLISH).startsWith("bear");

    }

    protected String getAuthzHeader(ServletRequest request) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        return httpRequest.getHeader(AUTHORIZATION_HEADER);
    }

    protected String[] getPrincipalsAndCredentials(String authorizationHeader, ServletRequest request) {
        if (authorizationHeader == null) {
            return null;
        }
        String[] authTokens = authorizationHeader.split(" ");
        if (authTokens == null || authTokens.length < 2) {
            return null;
        }
        return getPrincipalsAndCredentials(authTokens[0], authTokens[1]);
    }

    protected String[] getPrincipalsAndCredentials(String scheme, String encoded) {
        String decoded = Base64.decodeToString(encoded);
        return decoded.split(":", 2);
    }

    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
                                     ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String msg = "";
            Integer code = StatusCode.COMMON_FAIL;

            if(e instanceof UnknownAccountException){
                msg = "用户名错误";
                code = StatusCode.UNKNOWN_ACCOUNT;
            }else if(e instanceof DisabledAccountException){
                msg = "账户已被禁用";
                code = StatusCode.DISABLED_ACCOUNT;
            }else if(e instanceof LockedAccountException){
                msg = "账户已锁定";
                code = StatusCode.LOCKED_ACCOUNT;
            }else if(e instanceof ExcessiveAttemptsException){
                msg = "登陆次数失败过多";
                code = StatusCode.EXCESSIVE_ATTEMPS;
            }else if(e instanceof IncorrectCredentialsException){
                msg = "凭证错误";
                code = StatusCode.INCORRECT_CREDENTIALS;
            }else if(e instanceof ExpiredCredentialsException){
                msg = "凭证已过期";
                code = StatusCode.EXPIRED_CREDENTIALS;
            }else{
                msg = "系统错误";
                code = StatusCode.COMMON_FAIL;
            }
            JSONResult result = new JSONResult(false,msg,code);
            writer.write(result.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        writer.flush();
        writer.close();
        return false;
    }

    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String className = ae.getClass().getName();
        request.setAttribute(getFailureKeyAttribute(), className);
    }

    public String getFailureKeyAttribute() {
        return failureKeyAttribute;
    }





}
