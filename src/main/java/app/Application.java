package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import app.model.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Проверка Cat (prototype)
        System.out.println("=== Проверка Cat (prototype) ===");

        Cat cat1 = applicationContext.getBean("cat", Cat.class);
        Cat cat2 = applicationContext.getBean("cat", Cat.class);
        System.out.println("Cat (prototype) - ссылки одинаковые? " + (cat1 == cat2));
        System.out.println();

        // Проверка AnimalsCage с Timer
        System.out.println("=== Проверка AnimalsCage с Timer (singleton) ===");
        System.out.println("Запускаем 5 раз whatAnimalSay():");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            AnimalsCage bean = applicationContext.getBean(AnimalsCage.class);
            bean.whatAnimalSay();
        }

        // Дополнительная проверка
        System.out.println("=== Дополнительная проверка ===");
        AnimalsCage cage1 = applicationContext.getBean(AnimalsCage.class);
        AnimalsCage cage2 = applicationContext.getBean(AnimalsCage.class);
        System.out.println("AnimalsCage (singleton) - ссылки одинаковые? " + (cage1 == cage2));
        System.out.println("Timer (singleton) - ссылки одинаковые? " + (cage1.getTimer() == cage2.getTimer()));
        System.out.println("Животное в клетке: " + cage1.getAnimal().getClass().getSimpleName());
    }
}