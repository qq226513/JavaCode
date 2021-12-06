package studyCode.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JBUtils {
    public static String user;
    public static String password;
    public static String url;
    public static String driver;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src//mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connection(){
        try {
            return  DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rs, Statement st,Connection con){
        try {
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
