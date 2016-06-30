package com.cristik.common.exception;

import com.cristik.common.base.JSONResult;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghua on 2016/3/21.
 */
public class MessageExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        if (!(request.getHeader("accept").indexOf("application/json") > -1 ||
                (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)||
                (request.getHeader("content-type")!=null&&request.getHeader("content-type").indexOf("application/json")>-1))) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            if (exception instanceof BusinessException) {
                map.put("errorMsg", ((BusinessException) exception).getMsg());
            } else {
                map.put("errorMsg", "系统异常！");
            }
            exception.printStackTrace();
            return new ModelAndView("/error", map);
        } else {
            // 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                JSONResult result = new JSONResult();
                if(exception instanceof BusinessException){
                    result.setSuccess(false);
                    result.setMsg(((BusinessException) exception).getMsg());
                }else{
                    result.setMsg("系统异常");
                }
                writer.write(result.toString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
