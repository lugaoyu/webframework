package com.gaoyu.simple.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
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
public class CountryMapperTest
{
        private static SqlSessionFactory sqlSessionFactory;
        
        @BeforeClass
        public static void init()
        {
                try
                {
                        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                        reader.close();
                }
                catch(IOException e)
                {
                        e.printStackTrace();
                }
        }
        
        @Test
        public void testSelectAll()
        {
                SqlSession sqlSession = sqlSessionFactory.openSession();
                try
                {
                        List<Country> list = sqlSession.selectList("selectAll");
                        list.forEach(country -> System.out.println(country.getId()+country.getCountryname()+country.getCountrycode()));
                }
                finally
                {
                        sqlSession.close();
                }
        }
}
