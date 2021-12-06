package domain;

import java.sql.Statement;

public class eat_table {
    private Integer state;
    private Integer id;
    private Integer consume;
    private String order_name;
    private String order_tel;

    public eat_table() {
    }

    public eat_table(Integer state, Integer consume, String order_name, String order_tel) {
        this.state = state;
        this.consume = consume;
        this.order_name = order_name;
        this.order_tel = order_tel;
    }

    @Override
    public String toString() {
        String stateS = null;
        switch (state){
            case 0:
                stateS = "空";
                break;
            case 1:
                stateS = "已预订";
                break;
            case 2:
                stateS = "已占座";
                break;
        }
        return "餐桌号："+(id+"")+
                " \t\t当前状态："+stateS+
                " \t\t预订人："+order_name+
                " \t\t电话号码："+(order_tel+"")
                +" \t\t消费金额："+(consume+"");
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_tel() {
        return order_tel;
    }

    public void setOrder_tel(String order_tel) {
        this.order_tel = order_tel;
    }
}
