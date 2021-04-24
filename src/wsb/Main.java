package wsb;

import wsb.annotations.Init;
import wsb.annotations.ObjectToSqlConverter;
import wsb.annotations.ObjectToXmlConverter;
import wsb.creatures.Animal;
import wsb.creatures.Gender;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.devices.Car;
import wsb.devices.Device;
import wsb.devices.DieselCar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;

public class Main {

//    public static void main(String[] args) throws Exception {

//        System.out.println("fields:");
//        Field[] fields = Human.class.getDeclaredFields();
//        for(Field field : fields){
//            System.out.println(field.toGenericString());
//        }
//        System.out.println("methods:");
//        Method[] methods = Human.class.getMethods();
//        for(Method method : methods){
//            System.out.println(method.toGenericString());
//        }

    //        ObjectToXmlConverter converter = new ObjectToXmlConverter();
//        String ret = converter.convert(new Animal(Animal.Species.DOG));
//        System.out.println(ret);
//    }


    public static void main(String[] args) {
        ObjectToSqlConverter converter = new ObjectToSqlConverter();

        Human me = new Human(Gender.MAN);
        Animal dog = new Animal(Animal.Species.DOG);
        Car vw = new DieselCar("VW","GOLF",2008,1.8);


        System.out.println("OUR SQL CONVERTER:");
        try {
            System.out.println(converter.insert(me));
            System.out.println(converter.insert(dog));
            System.out.println(converter.insert(vw));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
