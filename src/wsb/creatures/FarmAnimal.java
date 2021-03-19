package wsb.creatures;

public class FarmAnimal extends Animal implements Edible {

    public FarmAnimal(Animal.Species species) {
        super(species);
    }

    @Override
    public void beEaten() {
        this.kill();
        System.out.println("that was yuammy");
    }
}
