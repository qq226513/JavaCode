package studyCode.MyJDBC;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AllPermission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@SuppressWarnings({"ALL"})
//java连接数据库的五种方式
public class MyJDBC2 {

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        String sql = "insert into dept values (11,'study','beijing')";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        statement.close();
        connect.close();
    }

    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //利用反射机制动态加载
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        String sql = "insert into dept values (11,'study','beijing')";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        statement.close();
        connect.close();
    }

    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //用DriverManager来替换Driver进行统一管理
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "123456";
        //DriverManager来获取链接对象
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "insert into dept values (11,'study','beijing')";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //加载"com.mysql.jdbc.Driver"类时自动注册驱动
        //static {
        //        try {
        //            DriverManager.registerDriver(new Driver());
        //        } catch (SQLException var1) {
        //            throw new RuntimeException("Can't register driver!");
        //        }
        //    }

        //mysql5.1.6之后无需Class.forName("com.mysql.jdbc.Driver");
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
    //改进使用配置文件
    @Test
    public void connect05() throws ClassNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
