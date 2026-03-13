package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Список всех пользователей
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";  // представление users.html
    }

    // Форма добавления нового пользователя
    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";  // одна форма и для добавления, и для редактирования
    }

    // Сохранение нового пользователя (POST)
    @PostMapping
    public String createUser(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam(required = false) Integer age) {
        User user = new User(name, email, age);
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Форма редактирования пользователя
    @GetMapping("/edit")
    public String editUserForm(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    // Обновление пользователя (POST)
    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam(required = false) Integer age) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setAge(age);
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    // Удаление пользователя (POST)
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}