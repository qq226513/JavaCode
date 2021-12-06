package HomeWork;



public class HomeWork03 {
    public static void main(String[] args) {
        VehiclesFactory vehiclesFactory = new VehiclesFactory();
        Person tang = new Person("唐僧", VehiclesFactory.getBoat());
        tang.passMon();
        tang.passRiver();
        tang.common();

    }
}
interface Vehicles{
    void work();
}
class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("骑马");
    }
}
class Plane implements Vehicles{

    @Override
    public void work() {
        System.out.println("坐飞机");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("坐船");
    }
}

class VehiclesFactory{
    public static Horse horse = new Horse();
    public static Boat boat = new Boat();
    public static Plane plane = new Plane();
    public static Horse getHorse(){
        return horse;
    }
    public static Boat getBoat(){
        return boat;
    }
    public static Plane getPlane(){
        return plane;
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver(){
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common(){
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    public void passMon(){
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }
}