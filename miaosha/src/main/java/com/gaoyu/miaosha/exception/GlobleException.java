package com.gaoyu.miaosha.exception;

import com.gaoyu.miaosha.result.CodeMsg;

/**
 * 全局异常
 * ClassName: GlobleException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:21:56 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class GlobleException extends RuntimeException
{
        /**
         * serialVersionUID:TODO(用一句话描述这个变量表示什么).
         * @since JDK 1.7
         */
        private static final long serialVersionUID = 1L;
        private CodeMsg cm;
        public GlobleException(CodeMsg cm)
        {
                super(cm.toString());
                this.cm = cm;
        }
        public CodeMsg getCm()
        {
                return cm;
        }
}
