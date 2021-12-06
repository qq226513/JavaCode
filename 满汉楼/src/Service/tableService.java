package Service;

import DAO.tableDAO;
import domain.person;
import domain.table;
import org.junit.jupiter.api.Test;

import java.util.List;

public class tableService {
    tableDAO tableDAO = new tableDAO();

    public List<table> show() {
        String sql = "select * from eat_table";
        return tableDAO.queryMulti(sql, table.class);
    }

    public void book(int num, person bookPerson) {
        String sql = "update eat_table set state = ? where table_id = ?";
        tableDAO.update(sql, 1, num);
        sql = "update eat_table set order_name  = ? where table_id = ?";
        tableDAO.update(sql, bookPerson.getName(), num);
        sql = "update eat_table set order_tel  = ? where table_id = ?";
        tableDAO.update(sql, bookPerson.getTelNumber(), num);
    }

    public int getNum() {
        String sql = "select count(*) from eat_table";
        return Integer.parseInt(tableDAO.queryScalar(sql).toString());
    }

    public int getState(int num) {
        String sql = "select state from eat_table where table_id = ?";
        return Integer.parseInt(tableDAO.queryScalar(sql, num).toString());
    }

    public void changeState(int table_id, int state) {
        String sql = "update eat_table set state = ? where table_id = ?";
        if (state == 2) {
            tableDAO.update(sql, state,table_id);
        }
    }

    public void setConsume(int table_id, int money) {
        String sql = "update eat_table set consume = ? where table_id = ?";
        tableDAO.update(sql, money, table_id);
    }
}
