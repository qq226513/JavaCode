package customGeneric;

import org.junit.jupiter.api.Test;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {

    }
    @Test
    public void listTest(){
        Dao<user> dao = new Dao<>();
        dao.save("张安",new user("张安",10,100));
        dao.save("张三",new user("张三",11,100));
        dao.save("张四",new user("张四",12,100));
        dao.delete("张三");
        dao.update("张四",new user("张思",12,100));
        System.out.println(dao.get("张四"));
        List<user> list = dao.list();
        System.out.println(list);
    }
    @Test
    public void deleteTest(){
        Dao<user> dao = new Dao<>();
        dao.save("张安",new user("张安",10,100));
        dao.save("张三",new user("张三",11,100));
        dao.save("张四",new user("张四",12,100));
        dao.delete("张三");
    }
}

class Dao<T>{
    Map<String,T> map = new HashMap<>() ;
    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
       return map.get(id);
    }
    public void update(String id,T entity){
        map.replace(id,entity);
    }
    public List<T> list(){
        Collection<T> values = map.values();
        return new ArrayList<>(values);
    }
    @Test
    public void delete(String id){
        map.remove(id);
    }
}
class user{
    private String name;
    private int id;
    private int age;

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public user(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
