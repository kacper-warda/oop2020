package wsb.devices;

public abstract class Device {
        final public String producer;
        final public String model;
        public Double value;

    public Device(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

   public abstract void turnOn();

    public String getModel(){
        return this.model;
    }

}
