abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cách di chuyển: Di chuyển bằng động cơ");
    }
}

class Bicycle extends Vehicle {

    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cách di chuyển: Di chuyển bằng sức người");
    }
}

public class Bai2 {
    public static void main(String[] args) {

        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Giant");

        car.move();
        bicycle.move();
    }
}