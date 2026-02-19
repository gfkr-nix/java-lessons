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

      // Создаем пользователей с машинами
      Car car1 = new Car("Toyota", 1234);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(car1);
      car1.setUser(user1);
      userService.add(user1);

      Car car2 = new Car("Honda", 5678);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(car2);
      car2.setUser(user2);
      userService.add(user2);

      Car car3 = new Car("BMW", 9012);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(car3);
      car3.setUser(user3);
      userService.add(user3);

      Car car4 = new Car("Audi", 3456);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(car4);
      car4.setUser(user4);
      userService.add(user4);

      // Выводим всех пользователей с их машинами
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Model = "+user.getCar().getModel());
            System.out.println("Car Series = "+user.getCar().getSeries());
         } else {
            System.out.println("No car");
         }
         System.out.println();
      }

      // Тестируем новый метод: получаем пользователя по модели и серии машины
      User foundUser = userService.getUserByCarModelAndSeries("Toyota", 1234);
      if (foundUser != null) {
         System.out.println("Found user by car (Toyota, 1234):");
         System.out.println("User: " + foundUser.getFirstName() + " " + foundUser.getLastName());
         System.out.println("Car: " + foundUser.getCar().getModel() + " " + foundUser.getCar().getSeries());
      } else {
         System.out.println("User with car (Toyota, 1234) not found");
      }

      context.close();
   }
}
