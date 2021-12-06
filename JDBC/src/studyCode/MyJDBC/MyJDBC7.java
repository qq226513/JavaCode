package studyCode.MyJDBC;

import studyCode.Utils.JBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//批处理应用
public class MyJDBC7 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JBUtils.connection();
        String sql = "insert into admin2 values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,1000);
            preparedStatement.addBatch();
            if ((i+1)%1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        JBUtils.close(null,preparedStatement,connection);

    }
}
