package interfaceTest;

public class study2 {
    public static void main(String[] args) {
        Mysql mysql = new Mysql();
        Oracle oracle = new Oracle();
        getConnection(mysql);
        getConnection(oracle);
    }
    public static void getConnection(DBConnection dbConnection){
        dbConnection.connect();
        dbConnection.close();

    }
}
interface DBConnection{
    void connect();
    void close();
}
class Mysql implements DBConnection{
    @Override
    public void connect() {
        System.out.println("Mysql连接");
    }
    @Override
    public void close() {
        System.out.println("Mysql关闭");
    }
}
class Oracle implements DBConnection{

    @Override
    public void connect() {
        System.out.println("Oracle连接");
    }

    @Override
    public void close() {
        System.out.println("Oracle关闭");
    }
}
