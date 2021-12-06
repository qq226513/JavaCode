package studyCode.Test;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PrepareStatementTest {
    @Test
    public void test() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "delete from employee where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"jack");
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();


    }
}
