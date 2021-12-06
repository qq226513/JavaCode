package domain;

public class person {
    private String name;
    private String telNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public person(String name, String telNumber) {
        this.name = name;
        this.telNumber = telNumber;
    }

    public person() {
    }
}
