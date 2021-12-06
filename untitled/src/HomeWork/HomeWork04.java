package HomeWork;

public class HomeWork04 {
    public static void main(String[] args) {
        switch (Color.RED){
            case RED:
                System.out.println(Color.RED);;
                break;
            case BLUE:
                System.out.println(Color.BLUE);;
                break;
            case BLACK:
                System.out.println(Color.BLACK);;
                break;
            case GREEN:
                System.out.println(Color.GREEN);;
                break;
            case YELLOW:
                System.out.println(Color.YELLOW);;
                break;
            default:
                System.out.println("没有这个颜色");
        }
    }
}
enum Color implements ColorShow{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);
    int redValue;
    int greenValue;
    int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public String toString() {
        return "Color{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }

    @Override
    public void show() {
        Color[] values = Color.values();
        for (Color value : values) {
            System.out.println(value);
        }
    }
}
interface ColorShow{
    void show();
}