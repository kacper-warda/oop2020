package wsb.annotations;

import java.lang.reflect.Field;

public class ObjectToSqlConverter {

    public String insert(Object object) throws IllegalAccessException {

        //INSERT INTO table_name(columnName1, columnName2)
        //VALUES (value1, value2, …);

        StringBuilder sql = new StringBuilder("INSERT INTO " + object.getClass().getSimpleName());

        for(Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            sql.append(field.getName()).append(", ");
        }

        sql.append(") values(");
        for(Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            sql.append(field.get(object)).append(", ");
        }

        sql.append(");");
        

        return sql.toString();
    }
}
