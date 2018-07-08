package com.gaoyu.miaosha.result;

/**
 * 
 * ClassName: Result <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午7:09:55 <br/>
 *
 * @author gaoyu
 * @version @param <T>
 * @since JDK 1.7
 */
public class Result<T>
{
        private int code;
        
        private String msg;
        
        private T data;
        
        private Result(T data)
        {
                this.code = 0;
                this.msg = "success";
                this.data = data;
        }
        
        private Result(CodeMsg cm)
        {
                if (cm == null)
                {
                        return;
                }
                this.code = cm.getCode();
                this.msg = cm.getMsg();
        }
        
        public static <T> Result<T> success(T data)
        {
                return new Result<T>(data);
        }
        
        public static <T> Result<T> error(CodeMsg cm)
        {
                return new Result<T>(cm);
        }
        
        public int getCode()
        {
                return code;
        }
        
        public void setCode(int code)
        {
                this.code = code;
        }
        
        public T getData()
        {
                return data;
        }
        
        public void setData(T data)
        {
                this.data = data;
        }
        
        public String getMsg()
        {
                return msg;
        }
        
        public void setMsg(String msg)
        {
                this.msg = msg;
        }
}
