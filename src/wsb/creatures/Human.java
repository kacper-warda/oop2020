package wsb.creatures;

import wsb.devices.Car;
import wsb.devices.Phone;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    public Pet pet;
    public Phone mobile;
    public Car car;

    public FarmAnimal[] farmAnimals;

    protected String phoneNumber;
    private Double salary;
    public Double cash = 200.0;

    private static Double DEFAULT_FEED_WEIGHT = 1.5;

    public Human() {
        super("homo sapiens");
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
