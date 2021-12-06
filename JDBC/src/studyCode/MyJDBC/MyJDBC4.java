package studyCode.MyJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
@SuppressWarnings({"all"})
//PreparedStatement使用
public class MyJDBC4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //得到PreparedStatement
        String sql="select emp_id,name,sex from employee where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给？值，占位符是从1开始计算的

        preparedStatement.setString(1,"张三丰");
//        preparedStatement.setString(2,sex);
        //执行select用Qurey
        //执行DML用update
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("yes");
        }
        //关闭资源
        preparedStatement.close();
        connection.close();



    }
}
