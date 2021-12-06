package domain;

public class menu {
    private String food_name;
    private Integer id;
    private Integer price;
    private String type;

    @Override
    public String toString() {
        return " 菜号:"+(id+"")+"\t\t菜名:"+food_name+"\t\t价格:"+(price+"")+"\t\t类型:"+type;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public menu(String food_name, Integer id, Integer price, String type) {
        this.food_name = food_name;
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public menu() {
    }
}
