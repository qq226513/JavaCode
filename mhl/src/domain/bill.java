package domain;

import java.util.Date;

public class bill {
    private Integer id;
    private Date time;
    private String content;
    private Integer table_id;

    @Override
    public String toString() {
        return "账单号："+(id+"")+"\t\t日期："+time+"\t\t备注："+content+"\t\t餐桌号："+table_id+"";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public bill() {
    }

    public bill(Integer id, Date time, String content, Integer table_id) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.table_id = table_id;
    }
}
