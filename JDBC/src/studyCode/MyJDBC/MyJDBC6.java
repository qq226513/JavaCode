package studyCode.MyJDBC;

import org.junit.jupiter.api.Test;
import studyCode.Utils.JBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings({"all"})
//事务处理实例：转账

public class MyJDBC6 {
    @Test
    public void useTransaction(){
        Connection connection = null;
        String sql = "";
        PreparedStatement preparedStatement = null;

        try {
            //设置为不自动提交
            connection = JBUtils.connection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            //在这里可以进行回滚
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            JBUtils.close(null, preparedStatement, connection);
        }
    }
}
