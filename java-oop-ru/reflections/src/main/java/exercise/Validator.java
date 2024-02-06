package exercise;

import java.util.HashMap;
import java.util.Map;
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

    public static Map<String, List<String>> advancedValidate(Object object) {
        var notValidatedFields = new HashMap<String, List<String>>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            var hasNotNullAnnotation = field.getAnnotation(NotNull.class) != null;
            var hasMinLengthAnnotation = field.getAnnotation(MinLength.class) != null;
            try {
                var value = field.get(object);
                var errorMessages = new ArrayList<String>();
                if (value == null) {
                    if (hasNotNullAnnotation) {
                        errorMessages.add("can not be null");
                    }
                } else if (hasMinLengthAnnotation){
                    var minLength = field.getAnnotation(MinLength.class).minLength();
                    if (value.toString().length() < minLength) {
                        errorMessages.add("length less than " + minLength);
                    }
                }
                if (!errorMessages.isEmpty()) {
                    notValidatedFields.put(field.getName(), errorMessages);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return notValidatedFields;
    }
}
// END
