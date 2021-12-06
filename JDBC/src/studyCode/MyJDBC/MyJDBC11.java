package studyCode.MyJDBC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import studyCode.Utils.SUPER_JBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@SuppressWarnings({"all"})
//使用apache
public class MyJDBC11 {
    @Test
    public void select() {
        Connection connection = null;
        String sql = "select name from employee";
        //1.得到连接
        try {
            connection = SUPER_JBUtils.getConnection();
            //2.使用DBUtils类和接口
            //创建QueryRunner
            QueryRunner queryRunner = new QueryRunner();
            //执行sql语句并得到一个ResultSet，并将其封装到ArrayList集合中
            //参数： new BeanListHandler<>(employee.class)：查询多行多列
            //最后是一个可变参数，用于填充占位符
            List<employee> query = queryRunner.query(connection, sql, new BeanListHandler<>(employee.class));
            for (employee e :
                    query) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭时只需要关闭Connection
        SUPER_JBUtils.close(null, null, connection);

    }

    @Test
    public void selectSingle() {
        Connection connection = null;
        String sql = "select * from employee where emp_id = ?";
        try {
            connection = SUPER_JBUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            //查询单行记录 BeanHandler
            employee query = queryRunner.query(connection, sql, new BeanHandler<>(employee.class), 10);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SUPER_JBUtils.close(null, null, connection);
        }
    }

    @Test
    public void selectScalar() {
        Connection connection = null;
        String sql = "select name from employee where emp_id = ?";
        try {
            connection = SUPER_JBUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            //查询单行单列用 ScalarHandler
            Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 10);
            System.out.println(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SUPER_JBUtils.close(null, null, connection);
        }
    }

    //DML语句
    @Test
    public void update() {
        Connection connection = null;
        String sql = "update employee set name = ? where emp_id = ?";
        try {
            connection = SUPER_JBUtils.getConnection();
            //用update来执行
            QueryRunner queryRunner = new QueryRunner();
            //返回被执行的行数
            int i = queryRunner.update(connection, sql, "张其", 10);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SUPER_JBUtils.close(null, null, connection);
        }
    }

    @Test
    public void delete() {
        Connection connection = null;
        String sql = "delete from employee ";
        try {
            connection = SUPER_JBUtils.getConnection();
            //用update来执行
            QueryRunner queryRunner = new QueryRunner();
            //返回被执行的行数
            int update = queryRunner.update(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SUPER_JBUtils.close(null, null, connection);
        }
    }
    @Test
    public void insert(){
        Connection connection = null;
        String sql = "insert into employee values(?,?,?,?,?,?)";
        try {
            connection = SUPER_JBUtils.getConnection();
            //用update来执行
            QueryRunner queryRunner = new QueryRunner();
            //返回被执行的行数
            int update = queryRunner.update(connection, sql, 422,"愁死","男",20000,"北京",20);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SUPER_JBUtils.close(null, null, connection);
        }
    }
}
