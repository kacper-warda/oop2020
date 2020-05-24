package wsb.creatures;

import wsb.devices.Car;
import wsb.devices.Phone;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    public Pet pet;
    public Phone mobile;
    public Car car;

    public Animal[] farm;

    protected String phoneNumber;
    private Double salary;
    public Double cash = 200.0;

    private static final int DEFAULT_FARM_SIZE = 3;
    private static Double DEFAULT_FEED_WEIGHT = 1.5;

    public Human(Integer farmSize) {
        super("homo sapiens");
        farm = new Animal[farmSize];
    }
    
    public Human() {
        super("homo sapiens");
        farm = new Animal[DEFAULT_FARM_SIZE];
    }

    public Double getSalary() {
        return salary;
    }

    public void sell() throws Exception {
        throw new Exception("don't do this freak");
    }

    public void eat() throws Exception {
        throw new Exception("don't do this freak");
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " I'm a human";
    }

    public void feed() {
        System.out.println("I'm a human I will use fork and knife");
        super.feed(DEFAULT_FEED_WEIGHT);
    }


}
