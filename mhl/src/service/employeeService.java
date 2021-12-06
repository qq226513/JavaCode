package service;

import dao.employeeDAO;

public class employeeService {
    employeeDAO employeeDAO = new employeeDAO();
    public boolean check(String emp_id,String password){
        String sql = "select password from employees where emp_id = ?";
        Object o = employeeDAO.queryScalar(sql, emp_id);
        return o.equals(password);
    }
}
