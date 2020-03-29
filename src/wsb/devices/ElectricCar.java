package wsb.devices;

public class ElectricCar extends Car {
    public ElectricCar(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction, null);
    }

    @Override
    public void refuel() {
        System.out.println("Refueled with electric power");
    }

    public String toString(){
        return "That is an electric car " + super.toString();
    }
}
