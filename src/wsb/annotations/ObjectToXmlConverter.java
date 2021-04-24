package wsb.annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToXmlConverter {


    private void checkIfSerializable(Object object) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception("The object to serialize is null");
        }

    }

    public String convert(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Mapped.class)) {
                jsonElementsMap.put(field.getName(), field.get(object)==null?"null":field.get(object).toString());
            }
        }
        for (Field field : clazz.getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Mapped.class)) {
                jsonElementsMap.put(field.getName(), field.get(object)==null?"null":field.get(object).toString());
            }
        }


        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{\"" + clazz.getSimpleName() + "\":{\"fields\":{"+ jsonString + "}}}";
    }
}
