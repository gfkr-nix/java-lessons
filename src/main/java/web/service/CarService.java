package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota Camry", 2020, "Silver"));
        cars.add(new Car("Honda Accord", 2019, "Black"));
        cars.add(new Car("BMW X5", 2021, "White"));
        cars.add(new Car("Audi A6", 2018, "Blue"));
        cars.add(new Car("Mercedes-Benz E-Class", 2022, "Gray"));
    }

    /**
     * Возвращает список машин.
     * Если count <= 0 или count >= 5, возвращает весь список.
     * Иначе возвращает первые count машин.
     */
    public List<Car> getCars(int count) {
        if (count <= 0 || count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}