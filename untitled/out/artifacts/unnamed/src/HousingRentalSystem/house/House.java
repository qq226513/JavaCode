package HousingRentalSystem.house;

public class House {
    private int no;//编号
    private String owner;//房主
    private int telNumber;//电话
    private String address;//地址
    private int rent;//租金
    private boolean state;

    public House() {
    }

    public House(int no, String owner, int telNumber, String address, int rent, boolean state) {
        this.no = no;
        this.owner = owner;
        this.telNumber = telNumber;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public String isState() {
       return state?"已出租":"未出租";
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "House{" +
                "编号 " + no +
                ", 房主 '" + owner + '\'' +
                ", 电话 " + telNumber +
                ", 地址 '" + address + '\'' +
                ", 租金 " + rent +
                ", 状态 " + state +
                '}';
    }
}
