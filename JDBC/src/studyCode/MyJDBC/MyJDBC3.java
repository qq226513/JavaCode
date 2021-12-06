package studyCode.MyJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
@SuppressWarnings({"all"})
public class MyJDBC3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //得到连接
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //执行sql
        String sql = "select emp_id,name,sex from employee";
        Statement statement = connection.createStatement();
        //返回结果集
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            //根据列的数据类型使用resultSet的get方法
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            String string1 = resultSet.getString(3);
            System.out.println(anInt+" "+string+" "+string1);
        }
        //关闭连接
        statement.close();
        connection.close();
        resultSet.close();
    }


}
