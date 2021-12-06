package service;

import dao.menuDAO;
import domain.menu;

import java.util.List;

public class menuService {
    menuDAO menuDAO = new menuDAO();
    public List<menu> show(){
        String sql = "select * from menu";
        return menuDAO.queryMulti(sql,menu.class);
    }
    public boolean check(int foodID){
        String sql = "select count(*) from menu";
        int i = Integer.parseInt(menuDAO.queryScalar(sql).toString());
        return foodID <= i;
    }
    public Integer getPrice(int id){
        String sql = "select price from menu where id = ?";
        return Integer.parseInt(menuDAO.queryScalar(sql,id).toString());
    }

    public String getName(int foodId) {
        String sql = "select food_name from menu where id = ?";
        return menuDAO.queryScalar(sql,foodId).toString();
    }
}
