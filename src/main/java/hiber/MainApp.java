package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      // Создаем пользователей с автомобилями
      Car car1 = new Car("Toyota Camry", 2020);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      car1.setUser(user1);
      
      Car car2 = new Car("Honda Accord", 2019);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      car2.setUser(user2);
      
      Car car3 = new Car("BMW X5", 2021);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      car3.setUser(user3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Model = "+user.getCar().getModel());
            System.out.println("Car Series = "+user.getCar().getSeries());
         }
         System.out.println();
      }

      // Тестируем метод поиска пользователя по модели и серии машины
      User foundUser = userService.getUserByCarModelAndSeries("Toyota Camry", 2020);
      if (foundUser != null) {
         System.out.println("Found user by car: " + foundUser.getFirstName() + " " + foundUser.getLastName());
      } else {
         System.out.println("User not found by car");
      }

      context.close();
   }
}
