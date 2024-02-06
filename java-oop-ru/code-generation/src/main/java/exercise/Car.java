package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws Exception {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static Car unserialize(String json) throws Exception {
        return new ObjectMapper().readValue(json, Car.class);
    }
    // END
}
