package DataStructrue;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import javax.naming.PartialResultException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        EmpHashTable table = new EmpHashTable(11);
        Scanner sc = new Scanner(System.in);
        String str = "";
        int id = 1;//用于员工编号的自增
        int i = 0;//用于保存int类型数值
        boolean loop = true;
        do {
            System.out.println("=======员工菜单=======");
            System.out.println("请输入你要进行的操作：");
            System.out.println("1.add:添加员工");
            System.out.println("2.delete:删除员工");
            System.out.println("3.list:遍历员工信息");
            System.out.println("4.select:查询员工");
            System.out.println("5.update:更改员工信息");
            System.out.println("6.exit:退出系统");
            str = sc.next();
            switch (str) {
                case "1":
                    System.out.println("请输入员工姓名：");
                    str = sc.next();
                    System.out.println("请输入员工年龄");
                    i = Integer.parseInt(sc.next());
                    table.add(new Emp(id, i, str));
                    id++;
                    break;
                case "2":
                    System.out.println("请输入你要删除的员工编号:");
                    if (table.delete(Integer.parseInt(sc.next()))) {
                        System.out.println("删除成功");
                    }
                    break;
                case "3":
                    System.out.println("=======员工信息如下=======");
                    table.list();
                    break;
                case "4":
                    System.out.println("请输入你要查询的员工id：");
                    i = Integer.parseInt(sc.next());
                    Emp retrieve = table.retrieve(i);
                    System.out.println(retrieve);
                    break;
                case "5":
                    System.out.println("请输入你要更改的员工id：");
                    i = Integer.parseInt(sc.next());
                    table.update(i);
                    break;
                case "6":
                    System.out.println("系统关闭");
                    loop = false;
            }

        } while (loop);
    }
}

class Emp {//雇员节点
    private int id;
    private int age;
    private String name;
    Emp next;

    public Emp(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Emp() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id && age == emp.age && name.equals(emp.name) && Objects.equals(next, emp.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, next);
    }
}

class EmpLinkedNode {//链表节点
    Emp head;


    public void add(Emp emp) {//在链表的结尾添加节点
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (!temp.equals(emp)) {
            temp.next = emp;
        } else {
            System.out.println("你要添加的节点已存在");
        }
    }

    public boolean delete(int id) {//通过id删除节点
        if (head == null){
            System.out.println("没有这个节点");
            return false;
        }
        Emp temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else if (temp == head) {
            head = null;
        } else {
            System.out.println("你输入的节点不存在");
            return false;
        }
        return true;

    }

    public void update(int id) {
        Emp temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            Scanner sc = new Scanner(System.in);
            String str = "";
            System.out.println("请输入你要修改的年龄");
            str = sc.next();
            int age = Integer.parseInt(str);
            temp.setAge(age);
            System.out.println("请输入你要修改的名字");
            str = sc.next();
            temp.setName(str);
        } else {
            System.out.println("你要修改的节点没有找到");
        }
    }

    public Emp retrieve(int id) {
        Emp temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("你要查询的节点没有找到");
        }
        return temp;
    }

    public void list() {
        Emp temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }
}

class EmpHashTable {//哈希表，即链表节点数组
    int size;
    int index;
    EmpLinkedNode[] table;

    public EmpHashTable(int size) {
        this.size = size;
        table = new EmpLinkedNode[size];
        for (int i = 0; i < size; i++) {
            table[i] = new EmpLinkedNode();
        }
    }

    public int HashFun(int id) {
        return id % size;
    }

    public void add(Emp emp) {
        index = HashFun(emp.getId());
        table[index].add(emp);
    }

    public boolean delete(int id) {
        if (id < 0) {
            System.out.println("你输入的id有误");
            return false;
        }
        int index = HashFun(id);
        return table[index].delete(id);

    }

    public void update(int id) {
        index = HashFun(id);
        table[index].update(id);
    }

    public Emp retrieve(int id) {
        index = HashFun(id);
        return table[index].retrieve(id);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.print("第" + (i + 1) + "行：");
            table[i].list();
        }
    }
}