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
        me.car = dirtyOne;
        System.out.println(me.car.producer + " " + me.car.model + " " + me.car.plates);


        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human(4);
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.car = new ElectricCar("Tesla", "S", 2019);


        System.out.println(me.car);
        System.out.println(me);

        Human brotherInLaw = new Human(2);
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

        me.car.sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.car);
        System.out.println("His car is now: " + brotherInLaw.car);


        Scanner consoleInput = new Scanner(System.in);  // Create a Scanner object


        System.out.println("gimme species");

//        for(int i = 0; i < me.farm.length; i++){
//            me.farm[i] = new FarmAnimal(consoleInput.nextLine());
//        }

        me.farm[0] = new Pet("dog");
        me.farm[1] = new FarmAnimal("cow");
        me.farm[2] = new Human(0);

        Arrays.sort(me.farm);

        System.out.println(me.farm[0]);
        System.out.println(me.farm[1]);
        System.out.println(me.farm[2]);


    }
}
