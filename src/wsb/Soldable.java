package wsb;

import wsb.creatures.Human;

public interface Soldable {
//    public void sell() throws Exception;
    void sell(Human buyer, Human seller, Double price) throws Exception;
}
