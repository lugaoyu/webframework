package com.gaoyu.bootstrap;

/**
 * 迷你-mvc框架(基于注解)
 * (0) 提供基础注解信息
 * (@Controller,@Autowired,@Service,@Repository)
 * (@RequestMapping,@RequestBody,@ResponseBody)
 * (1) 扫描基础包,管理包下所有bean对象
 * (2) 对于注解类类型,分类管理
 * (3) 对于RequestMapping需要建立请求URL和类，及处理method的映射关系
 * (4) 对于RequestBody,需要将请求参数封装如请求对象中
 * (5) 对于ResponseBody,需要将返回体封装到该对象中,返回
 * ClassName: Bootstrap <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年3月25日 上午9:18:25 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class Bootstrap 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
