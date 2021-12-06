package domain;

public class Menu {
    private String food_name;
    private int price;
    private String type;

    public Menu(String food_name, int price, String type) {
        this.food_name = food_name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "菜名：'" + food_name + '\'' +
                ", 价格：" + price +
                ", 类型：'" + type + '\'' +
                '}';
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Menu() {
    }
}
