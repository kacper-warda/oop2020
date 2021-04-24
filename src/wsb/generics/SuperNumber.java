package wsb.generics;

public class SuperNumber<T extends Number> {
    public T value;

    public SuperNumber(T value) {
        this.value = value;
    }

    public void printClass() {
        System.out.println(value.getClass().getName());
    }

    public int intValue() {
        return this.value.intValue();
    }

    public double doubleValue() {
        return this.value.doubleValue();
    }

    public boolean equalValues() {
        return this.doubleValue() == this.intValue();
    }

    public boolean equalIntValues(SuperNumber<?> otherNumber){
        return this.intValue() == otherNumber.intValue();
    }

    public boolean equalDoubleValues(SuperNumber<?> otherNumber){
        return this.doubleValue() == otherNumber.doubleValue();
    }

}
