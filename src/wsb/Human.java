package wsb;

import wsb.devices.Car;
import wsb.devices.Phone;

public class Human extends Animal{
    public String firstName;
    public String lastName;
    public Animal pet;
    public Phone mobile;
    public Car car;

    protected String phoneNumber;
    private Double salary;

    public Human() {
        super("homo sapiens");
    }

    public Double getSalary() {
        return salary;
    }
}
