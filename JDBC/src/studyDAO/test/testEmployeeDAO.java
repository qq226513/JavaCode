package studyDAO.test;

import org.junit.jupiter.api.Test;
import studyDAO.DAO.employeeDAO;
import studyDAO.domain.employee;

import java.util.List;

public class testEmployeeDAO {
    @Test
    public void test1(){
        employeeDAO employeeDAO = new employeeDAO();
        String sql = "insert into employee values(?,?,?,?,?,?)";
        employeeDAO.update(sql,3,"张四","男",20020,"北京",41);
    }
    @Test
    public void test2(){
        employeeDAO employeeDAO = new employeeDAO();
        String sql = "select * from employee where emp_id = ?";
        employee employee = employeeDAO.querySingle(sql, employee.class, 1);
        System.out.println(employee);
    }

    @Test
    public void test(){
        employeeDAO employeeDAO = new employeeDAO();
        String sql = "select name from employee where emp_id = ?";
        Object o = employeeDAO.queryScalar(sql, 1);
        System.out.println(o);
    }
    @Test
    public void test4(){
        employeeDAO employeeDAO = new employeeDAO();
        String sql = "select * from employee ";
        List<employee> employees = employeeDAO.queryMulti(sql, employee.class);
        System.out.println(employees);
    }
}
