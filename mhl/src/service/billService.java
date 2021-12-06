package service;

import dao.BasicDAO;
import dao.billDAO;
import domain.bill;

import java.util.List;

public class billService {
    billDAO billDAO = new billDAO();
    public List<bill> show(){
        String sql = "select * from bill";
        return billDAO.queryMulti(sql, bill.class);
    }
    public void insert(String content,int cost,int table_id){
        String sql = "insert into bill values(?,now(),?,?,?)";
        billDAO.update(sql,null,content,cost,table_id);
    }
}
