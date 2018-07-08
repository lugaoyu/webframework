package com.gaoyu.miaosha.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoyu.miaosha.result.CodeMsg;
import com.gaoyu.miaosha.result.Result;

/**
 * 全局异常处理器
 * ClassName: GlobleExceptionHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:22:09 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler
{
        @ExceptionHandler(value = Exception.class)
        public Result<String> exceptionHandler(HttpServletRequest request,
                        Exception e)
        {
                e.printStackTrace();
                if (e instanceof GlobleException)
                {
                        GlobleException ex = (GlobleException)e;
                        return Result.error(ex.getCm());
                }
                else if (e instanceof BindException)
                {
                        BindException ex = (BindException)e;
                        List<ObjectError> allErrors = ex.getAllErrors();
                        ObjectError objectError = allErrors.get(0);
                        String defaultMessage = objectError.getDefaultMessage();
                        return Result.error(CodeMsg.BIND_ERROR.fillArgs(defaultMessage));
                }
                return Result.error(CodeMsg.SERVER_ERROR);
        }
}
