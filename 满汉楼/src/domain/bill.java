package domain;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class bill {
    private Integer id;
    private Integer table_id;
    private Integer bill_id;
    private Integer menu_id;
    private Integer nums;
    private Date billDate;
    private Integer money;
    private String state;

    public bill(Integer id, Integer table_id, Integer bill_id, Integer menu_id, Integer nums, Date billDate, Integer money, String state) {
        this.id = id;
        this.table_id = table_id;
        this.bill_id = bill_id;
        this.menu_id = menu_id;
        this.nums = nums;
        this.billDate = billDate;
        this.money = money;
        this.state = state;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public Integer getBill_id() {
        return bill_id;
    }

    public void setBill_id(Integer bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
