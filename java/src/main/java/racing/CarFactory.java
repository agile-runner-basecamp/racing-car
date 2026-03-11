package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> createCars(String rawNames){
        return Arrays.stream(rawNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
