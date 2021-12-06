package Service;

import DAO.empDAO;
import Utils.JDBCUtilsByDruid;
import domain.emp;

import java.sql.Connection;
import java.sql.SQLException;

//通过调用DAO对象完成操作
public class EmployeeService {
   empDAO empDAO = new empDAO();
   public boolean check(String emp_id,String password) throws SQLException {
       String sql = "select password from employees where emp_id = ? ";
       Object obj = empDAO.queryScalar(sql, emp_id);
       if (obj != null && obj.equals(password)){
           return true;
       }
       return false;

   }

}
