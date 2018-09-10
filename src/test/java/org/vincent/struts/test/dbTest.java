package org.vincent.struts.test;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PengRong on 2018/9/10.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "classpath:spring/ApplicationSpringContext.xml" })
public class dbTest {
    @Autowired
    private DruidDataSource dataSource ;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 测试 数据库连接池 数据源，SessionTemplate 模板实例是否可以获取以及，查询 SELECT  1 FROM  dual;
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(sqlSessionTemplate);
        DruidPooledConnection connection= dataSource.getConnection();
        PreparedStatement statement= connection.prepareStatement("SELECT  1 FROM  dual;");
        ResultSet set= statement.executeQuery();
        while (set.next()){
            System.out.println( set.getInt(1));
        }


    }
}
