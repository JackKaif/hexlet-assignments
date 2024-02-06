package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        var notValidatedFields = new ArrayList<String>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            var hasNotNullAnnotation = field.getAnnotation(NotNull.class) != null;
            try {
                var value = field.get(object);
                if (value == null && hasNotNullAnnotation) {
                    notValidatedFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return notValidatedFields;
    }

}
// END
