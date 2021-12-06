package studyCode.MyJDBC;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import studyCode.Utils.SUPER_JBUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//德鲁伊连接池使用
public class MyJDBC9 {
    @Test
    public void druidConnect() throws Exception {
        //获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        //DruidDataSourceFactory.createDataSource(properties);使用这个方法传入参数
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        connection.close();
    }
    @Test
    public void test() throws SQLException {
        Connection connection = SUPER_JBUtils.getConnection();
        String sql = "select * from employee where emp_id = 10";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }

    }
}
