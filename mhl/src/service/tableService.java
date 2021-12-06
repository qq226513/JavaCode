package service;

import dao.tableDAO;
import domain.eat_table;

import java.util.List;

public class tableService {
   dao.tableDAO tableDAO =  new tableDAO();
   public List<eat_table> show(){
       String sql = "select * from eat_table";
       return tableDAO.queryMulti(sql, eat_table.class);
   }
   public Integer getTableNums(){
       String sql = "select count(*) from eat_table";
       return Integer.parseInt(tableDAO.queryScalar(sql).toString());

   }
   public Integer getState(int table_id){
       String sql = "select state from eat_table where id = ?";
       return Integer.parseInt(tableDAO.queryScalar(sql,table_id).toString());
   }
   public Integer getConsume(int table_id){
       String sql  = "select consume from eat_table where id = ?";
       return Integer.parseInt(tableDAO.queryScalar(sql,table_id).toString());
   }
   public void book(String order_name,String order_tel,int table_id){
       String sql = "update eat_table set order_name = ? where id = ?";
       tableDAO.update(sql,order_name,table_id);
       sql = "update eat_table set order_tel = ? where id = ?";
       tableDAO.update(sql,order_tel,table_id);
       sql = "update eat_table set state = ? where id = ?";
       tableDAO.update(sql,1,table_id);
   }
   public void consume(int price,int table_id){
       String sql = "update eat_table set consume = consume + ? where id = ?";
       tableDAO.update(sql,price,table_id);
   }
   public void occupy(int table_id){
       String sql = "update eat_table set state = ? where id = ?";
       tableDAO.update(sql,2,table_id);
   }
   public void settlement(int table_id){
       String sql = "update eat_table set consume = 0 where id = ?";
       tableDAO.update(sql,table_id);
   }
}
