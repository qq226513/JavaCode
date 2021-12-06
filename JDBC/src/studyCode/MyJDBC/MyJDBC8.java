package studyCode.MyJDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//连接池使用
public class MyJDBC8 {
    @Test
    public void C3P0Connect01() throws Exception {

        //1.创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //通过配置文件获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源连接(comboPooledDataSource = DriverManager)设置参数
        comboPooledDataSource.setDriverClass(driver);//数据库驱动
        comboPooledDataSource.setJdbcUrl(url);//url
        //用户名和密码
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //获取连接
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }

    }
    @Test
    public void C3P0Connect02() throws SQLException {
        //将c3p0-config.xml添加到SRC下进行配置自动进行初始化
        ComboPooledDataSource hello = new ComboPooledDataSource("hello");
        //直接连接
        hello.getConnection();
        //关闭连接
        hello.close();

    }
}
