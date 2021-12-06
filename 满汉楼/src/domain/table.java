package domain;


public class table {
    private int state;
    private int table_id;
    private String order_name;
    private String order_tel;
    private Integer consume;

    public String getOrder_tel() {
        return order_tel;
    }

    public void setOrder_tel(String order_tel) {
        this.order_tel = order_tel;
    }

    public table() {
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public table(int state, int table_id, String order_name, String order_tel, Integer consume) {
        this.state = state;
        this.table_id = table_id;
        this.order_name = order_name;
        this.order_tel = order_tel;
        this.consume = consume;
    }

    @Override
    public String toString() {
        String state_S = "";
        switch (state) {
            case 0:
                state_S = "空";
            case 1:
                state_S = "已预订";
            case 2:
                state_S = "已占座";
        }
        return "餐桌号:" + table_id +
                " 状态：" + state_S +
                " 消费："+consume+
                " 预订人：" + (order_name == null ? "<尚未预定>" : order_name) +
                " 电话号码：" + (order_tel == null ? "<尚未预定>" : order_tel);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }


}
