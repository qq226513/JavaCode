package studyCode.MyJDBC;

import studyCode.Utils.JBUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MyJDBC5 {
    public static void main(String[] args) {
        Connection connection = null;
        String sql = "select emp_id from employee where name = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JBUtils.connection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "jack");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBUtils.close(resultSet, preparedStatement, connection);
        }
    }

}
