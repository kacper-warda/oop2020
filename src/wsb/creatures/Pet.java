package wsb.creatures;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(String species) throws SQLException {
        super(species);
    }
}
