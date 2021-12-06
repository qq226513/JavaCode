package interfaceTest;

public class study1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();
        computer.work(phone);
        computer.work(camera);

    }
}
interface UsbInterface{
    void start();
    void stop();
}
class Phone implements UsbInterface{

    @Override
    public void start() {
        System.out.println("手机接口");
    }

    @Override
    public void stop() {
        System.out.println("手机接口关闭");
    }

    public void call(){
        System.out.println("打电话");
    }
}
class Camera implements UsbInterface{

    @Override
    public void start() {
        System.out.println("相机接口");
    }

    @Override
    public void stop() {
        System.out.println("相机接口关闭");
    }
}

class Computer{
    public void work(UsbInterface usbInterface){
        if (usbInterface instanceof Phone){
            ((Phone) usbInterface).call();
        }
        usbInterface.start();
        usbInterface.stop();
    }
}
