package studyCode.MyJDBC;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyJDBC1 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.获取连接
        //jdbc:mysql://是固定的，是协议
        //localhost：主机名
        //3306：端口号
        //db001你要连接的数据库
        String url = "jdbc:mysql://localhost:3306/db001";
        //用户名和秘密封装
        Properties properties = new Properties();
        //user和password是规定好的，后面的是值
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //获取链接
        //根据给定的值进行链接
        Connection connect = driver.connect(url, properties);
        //3.执行sql语句
        String sql = "delete from dept where dept_id = 2";
        //需要有statement对象来执行静态sql语句
        Statement statement = connect.createStatement();
        //如果i大于0，则返回的是受影响的行数
        //executeUpdate用于执行sql语句
        int i = statement.executeUpdate(sql);
        System.out.println(i > 0 ? "成功" : "失败");


        //关闭链接
        statement.close();
        connect.close();


    }
}
