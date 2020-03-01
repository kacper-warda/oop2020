package wsb.devices;

public class Phone extends Device {
    final Double screenSize;

    public Phone(String producer, String model, Double screenSize) {
        super(producer,model);
        this.screenSize = screenSize;
    }
}
