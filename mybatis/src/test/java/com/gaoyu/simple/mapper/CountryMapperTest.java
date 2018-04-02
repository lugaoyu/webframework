package com.gaoyu.simple.mapper;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.gaoyu.simple.model.Country;


/**
 * 
 * ClassName: CountryMapperTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年3月31日 上午8:21:34 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class CountryMapperTest extends BaseMapperTest
{
    @Test
    public void testSelectAll()
    {
        SqlSession sqlSession = getSqlSession();
        try
        {
            List<Country> list = sqlSession.selectList("com.gaoyu.simple.model.CountryMapper.selectAll");
            list.forEach(country -> System.out.println(country.getId() + country.getCountryname()
                + country.getCountrycode()));
        }
        finally
        {
            sqlSession.close();
        }
    }
}
