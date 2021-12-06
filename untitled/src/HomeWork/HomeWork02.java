package HomeWork;

public class HomeWork02 {
    public static void main(String[] args) {
    new A().new B().show();
    }
}
class A{
    private String name = "A name";
    class B{
        private final String name = "name";
        public void show() {
            System.out.println(name);
            System.out.println(A.this.name);
        }
    }
}
