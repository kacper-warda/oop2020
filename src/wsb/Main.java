package wsb;

import wsb.creatures.Animal;
import wsb.creatures.FarmAnimal;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.devices.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Pet dog = new Pet("dog");
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7);

        Human me = new Human(3);
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;


        Car dirtyOne = new DieselCar("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.setCar(dirtyOne,0);
        System.out.println(me.getCar(0).producer + " " + me.getCar(0).model + " " + me.getCar(0).plates);


        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human(4);
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.setCar(new ElectricCar("Tesla", "S", 2019),0);


        System.out.println(me.getCar(0));
        System.out.println(me);

        Human brotherInLaw = new Human(2);
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

//        me.getCar(0).sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.getCar(0));
        System.out.println("His car is now: " + brotherInLaw.getCar(0));





    }
}
