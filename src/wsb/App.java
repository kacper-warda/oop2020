package wsb;

public class App {
    private String name;
    private String version;
    private Double price;

    public App(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name + " " + this.version;
    }
}
