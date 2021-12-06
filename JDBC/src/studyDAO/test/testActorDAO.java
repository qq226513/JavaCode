package studyDAO.test;

import org.junit.jupiter.api.Test;
import studyDAO.DAO.actorDAO;
import studyDAO.domain.actor;

import java.util.List;

public class testActorDAO {
    @Test
    public void t1(){
        actorDAO actorDAO = new actorDAO();
        String sql = "insert into actor values(?,?,?,?)";

        int update = actorDAO.update(sql, "黎明", "邵氏", "无间道", 900000);
        if (update != 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
    @Test
    public void t2(){
        actorDAO actorDAO = new actorDAO();
        String sql = "select * from actor";
        List<actor> actors = actorDAO.queryMulti(sql, actor.class);
        System.out.println("艺人名单");
        for (actor a :
                actors) {
            System.out.println(a);
        }
    }
    @Test
    public void t3(){
        actorDAO actorDAO = new actorDAO();
        String sql = "select * from actor where name = ?";
        actor a = actorDAO.querySingle(sql, actor.class, "张国荣");
        System.out.println(a);
    }
    @Test
    public void t4(){
        actorDAO actorDAO = new actorDAO();
        String sql = "select name from actor where company = ?";
        actor a = actorDAO.querySingle(sql, actor.class, "邵氏");
        System.out.println(a);
    }
}
