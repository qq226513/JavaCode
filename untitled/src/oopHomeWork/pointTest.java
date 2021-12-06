package oopHomeWork;

public class pointTest {
    public static void main(String[] args) {

    }
}
class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabelPoint extends Point{
    private String Label;

    public LabelPoint(double x, double y, String label) {
        super(x, y);
        Label = label;
    }
}
