package com.gaoyu.enums;

/**
 * 
 * ClassName: ShopStateEnum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月23日 上午10:58:36 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public enum ShopStateEnum
{
        CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2,
                        "通过认证"), INNER_ERROR(-1001, "操作失败"), NULL_SHOPID(-1002,
                        "ShopId为空"), NULL_SHOP_INFO(-1003, "传入了空的信息");
        
        private int state;
        
        private String stateInfo;
        
        private ShopStateEnum(int state, String stateInfo)
        {
                this.state = state;
                this.stateInfo = stateInfo;
        }
        
        public int getState()
        {
                return state;
        }
        
        public String getStateInfo()
        {
                return stateInfo;
        }
        
        public static ShopStateEnum stateOf(int index)
        {
                for (ShopStateEnum state : values())
                {
                        if (state.getState() == index)
                        {
                                return state;
                        }
                }
                return null;
        }
}
