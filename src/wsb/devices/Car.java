package wsb.devices;

import wsb.creatures.Human;
import wsb.Soldable;

public abstract class Car extends Device implements Soldable {
    public final Integer yearOfProduction;
    public final Double sizeOfAnEngine;
    public String plates;

    public Car(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine) {
        super(producer, model);
        this.yearOfProduction = yearOfProduction;
        this.sizeOfAnEngine = sizeOfAnEngine;

    }

    abstract public void refuel();

    @Override
    public void turnOn() {
        System.out.println("car is ready to go");
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.plates;
    }

    @Override
    public void sell(Human buyer, Human seller, Double price) throws Exception {
        if (buyer.cash >= price) {
            buyer.car = this;
            buyer.cash -= price;
            seller.car = null;
            seller.cash += price;
            System.out.println(seller.firstName + " sell a car (" + this.model + ") to " + buyer + " for " + price);
        } else {
            throw new Exception("you don't have enough cash to buy it");
        }
    }
}