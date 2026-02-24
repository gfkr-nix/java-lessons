package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> carList;

    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2020));
        carList.add(new Car("Honda", "Civic", 2019));
        carList.add(new Car("Ford", "Focus", 2021));
        carList.add(new Car("BMW", "X5", 2022));
        carList.add(new Car("Mercedes", "E-Class", 2023));
    }

    public List<Car> getCars(int count) {
        if (count >= carList.size()) {
            return carList;
        } else if (count <= 0) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(carList.subList(0, count));
        }
    }
}