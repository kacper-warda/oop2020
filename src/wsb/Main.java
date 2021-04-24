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
import wsb.generics.Container;
import wsb.generics.SuperNumber;

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

        SuperNumber<Double> myDouble = new SuperNumber<>(3.4);
        SuperNumber<Integer> myInteger = new SuperNumber<>(4);

        System.out.println(myDouble.doubleValue());
        System.out.println(myInteger.doubleValue());

        System.out.println(myDouble.equalValues());
        myDouble.value = 3.8456;
        System.out.println(myDouble.equalValues());
        myDouble.value = 3.0;
        System.out.println(myDouble.equalValues());

        System.out.println(myInteger.equalIntValues(myDouble));

    }
}
