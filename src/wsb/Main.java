package wsb;

import wsb.creatures.*;
import wsb.database.Connector;
import wsb.database.JDBCConnector;
import wsb.devices.*;

import java.sql.ResultSet;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {



        Human me = new Human(3, Gender.MAN);
        me.sayImFirst();
        System.out.println(Gender.WOMAN.name());




    }
}
