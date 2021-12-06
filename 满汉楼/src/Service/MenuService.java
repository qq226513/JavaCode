package Service;

import DAO.menuDAO;
import domain.Menu;

import java.util.List;

public class MenuService {
    menuDAO menuDAO = new menuDAO();
    public List<Menu> show(){
        String sql = "select * from menu";
        return menuDAO.queryMulti(sql, Menu.class);
    }
    public int getPrice(int id){
        String sql = "select price from menu where id = ?";
        return Integer.parseInt(menuDAO.queryScalar(sql,id).toString());
    }
    public String getName(int id){
        String sql = "select food_name from menu where id = ?";
        return menuDAO.queryScalar(sql,id).toString();
    }

}
