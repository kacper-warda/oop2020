package wsb;

import wsb.creatures.Animal;
import wsb.creatures.FarmAnimal;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.devices.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Pet dog = new Pet("dog");
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7);

        Human me = new Human();
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;


        Car dirtyOne = new DieselCar("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.car = dirtyOne;
        System.out.println(me.car.producer + " " + me.car.model + " " + me.car.plates);


        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human();
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.car = new ElectricCar("Tesla", "S", 2019);


        System.out.println(me.car);
        System.out.println(me);

        Human brotherInLaw = new Human();
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

        me.car.sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.car);
        System.out.println("His car is now: " + brotherInLaw.car);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(brotherInLaw.car);
        System.out.println(myWife.car);


    }


}
