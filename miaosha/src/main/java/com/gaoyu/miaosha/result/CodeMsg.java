package com.gaoyu.miaosha.result;

/**
 * 
 * ClassName: CodeMsg <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月21日 下午8:50:38 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class CodeMsg
{
        private int code;
        
        private String msg;
        
        private CodeMsg(int code, String msg)
        {
                this.code = code;
                this.msg = msg;
        }
        
        public static CodeMsg SUCCESS = new CodeMsg(0, "success");
        
        public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器异常");
        
        public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码不能为空");
        
        public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号码不能为空");
        
        public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号码格式错误");
        
        public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500213,"手机号码不存在");
        
        public static CodeMsg PASSWORD_ERROR = new CodeMsg(500213,"密码错误");
        
        public static CodeMsg BIND_ERROR = new CodeMsg(500101,"参数检验异常:%s");
        
        //秒杀模块 5005XX
        public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
        public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
        
        public int getCode()
        {
                return code;
        }
        
        public String getMsg()
        {
                return msg;
        }
        
        public CodeMsg fillArgs(Object...args)
        {
                int code = this.code;
                String messgae  = String.format(this.msg, args);
                return new CodeMsg(code,messgae);
        }
}
