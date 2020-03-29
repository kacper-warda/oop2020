package wsb;

import wsb.creatures.Animal;
import wsb.creatures.FarmAnimal;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.devices.Car;
import wsb.devices.Device;
import wsb.devices.Phone;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Animal dog = new Pet("dog");
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7);

        Human me = new Human();
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;

//        me.pet.feed();
//        me.pet.takeForAWalk();
//        me.pet.feed();
//        me.pet.takeForAWalk();
//        me.pet.takeForAWalk();
//        me.pet.takeForAWalk();
//        me.pet.takeForAWalk();

        Car dirtyOne = new Car("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.car = dirtyOne;
        System.out.println(me.car.producer + " " + me.car.model + " " + me.car.plates);

//        me.feed();
//        me.pet.feed();

        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human();
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.car = dirtyOne;


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

        iphone.installAnApp("Google Sheets");
        iphone.installAnApp("Google Sheets", 1.2);
        iphone.installAnApp(new String[]{"WhatsApp", "Messenger", "facebook"});

        Animal goldFish = new Animal("goldfish",0.04);
        System.out.println(goldFish);

        System.out.println(me);
        me.feed();

    }


}
