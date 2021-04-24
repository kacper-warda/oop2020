package wsb.creatures;

import wsb.annotations.Init;
import wsb.annotations.Mapped;
import wsb.database.Connector;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static wsb.creatures.Animal.Species.*;

public class Animal implements Feedable, Comparable<Animal> {

    public enum Species {
        DOG, CAT, MONKEY, GIRAFFE, HUMAN
    }

    private class Heart {
        double beatsPerSecond;
        double volume;
        boolean isBeating;

        public void stopAHeart() {
            this.beatsPerSecond = 0;
            this.isBeating = false;

        }
    }

    private final Heart heart;

    @Mapped
    final Species species;
    @Mapped
    private Double weight;
    @Mapped
    public String name;
    File pic;
    private static Map<Long, Animal> cache = new HashMap<>();


    private static Double NEW_DOG_WEIGHT = 4.0;
    private static Double NEW_LION_WEIGHT = 39.2;
    private static Double NEW_OTHER_ANIMAL_WEIGHT = 5.3;

    private static Double DEFAULT_FEED_WEIGHT = 1.0;

    public Animal(Species species) {
        System.out.println("we created new Animal");
        this.species = species;
        this.heart = new Heart();

        switch (species) {
            case DOG: {
                weight = NEW_DOG_WEIGHT;
                break;
            }
            case CAT: {
                weight = NEW_LION_WEIGHT;
                break;
            }
            default: {
                weight = NEW_OTHER_ANIMAL_WEIGHT;
                break;
            }
        }
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Animal(Species species, Double weight) {
        this.weight = weight;
        this.species = species;
        this.heart = new Heart();

        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void feed() {
        feed(DEFAULT_FEED_WEIGHT);
    }

    public void feed(Double foodWeight) {
        if (weight == 0) {
            System.out.println("too late, " + name + " is dead");
        } else {
            weight += foodWeight;
            System.out.println(name + " says thx for food");
        }
        Animal.cache.remove(1L);
    }

    public void takeForAWalk() {
        if (weight == 0.0) {
            System.out.println("you can't walk the street with dead animal you freak");
        } else if (weight > 3.0) {
            --weight;
            System.out.println(name + " says thx for a walk");
        } else if (weight > 1.0) {
            --weight;
            System.out.println(name + " says thx for a walk but I'm hungry");
        } else {
            weight = 0.0;
            System.out.println(name + " died");
        }
        Animal.cache.remove(1L);
    }

    Double getWeight() {
        return weight;
    }

    protected void kill() {
        System.out.println("byeeeeeeeeeeeeee");
        this.weight = 0.0;
        this.heart.stopAHeart();
        Animal.cache.remove(1L);
    }

    @Override
    public String toString() {
        return "Hi I'm an Animal " + this.species + " " + this.name;
    }

    @Override
    @Init
    public int compareTo(Animal o) {
        return this.species.compareTo(o.species);
    }

    public void save() throws SQLException {
        String sql = "insert into animal values ('" + this.species + "','" + this.name + "'," + this.weight + ");";
        System.out.println(sql);
//        Connector.executeSQL(sql);

        Animal.cache.remove(1L);
    }

    static public Animal getAnAnimalFromDatabase(Long id) throws InterruptedException {
        if (Animal.cache.containsKey(id)) {
            return Animal.cache.get(id);
        } else {
            System.out.println("looking for an animal in really large table");
            Thread.sleep(500);
            System.out.println("joining with another big table");
            Thread.sleep(500);
            System.out.println("mapping some data");
            Thread.sleep(1000);
            System.out.println("I've got it");
            Animal animal = new Animal(MONKEY, 15.0);
            Animal.cache.put(id, animal);
            return animal;
        }
    }

}
