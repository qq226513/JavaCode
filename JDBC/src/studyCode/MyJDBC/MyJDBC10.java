package studyCode.MyJDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ConnectionCustomizer;
import org.junit.jupiter.api.Test;
import studyCode.Utils.SUPER_JBUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class MyJDBC10 {
@Test
    public void test() {
        String sql = "select * from employee where emp_id = ?";
        PreparedStatement preparedStatement;
        Connection connection;
        ResultSet set;
        ArrayList<employee> list = new ArrayList<>();
        try {
            connection = SUPER_JBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 10);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String sex = set.getString(3);
                int sal = set.getInt(4);
                String address = set.getString(5);
                int age = set.getInt(6);
                list.add(new employee(name, id, sal, sex, address, age));
            }
            connection.close();
            System.out.println(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
