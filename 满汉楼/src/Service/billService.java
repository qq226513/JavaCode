package Service;

import DAO.billDAO;
import domain.bill;
import org.junit.jupiter.api.Test;

public class billService {
    billDAO billDAO = new billDAO();
    public void updateBill(bill b){
        String sql = "insert into bill values (?,?,?,?,?,now(),?,?)";
        billDAO.update(sql,0,b.getTable_id(),b.getBill_id(),
                b.getMenu_id(),b.getNums(),
                b.getMoney(),b.getState());
    }
}
