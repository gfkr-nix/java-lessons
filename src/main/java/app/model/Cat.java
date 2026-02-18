package app.model;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Мяу-мяу!");
    }

    @Override
    public String toString() {
        return "Im a Cat";
    }
}