package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CreateUser;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.dto.ResponseWrapperUser;



@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    /**
     * Добавляет пользователя
     */
    @PostMapping
    public ResponseEntity<CreateUser> addUser(@RequestBody CreateUser user) {
        return ResponseEntity.ok(user);
    }

    /**
     * Выводит всех пользователей
     */
    @GetMapping("/me")
    public ResponseEntity<ResponseWrapperUser> getUsers() {
        return ResponseEntity.ok(new ResponseWrapperUser());
    }

    /**
     * Вносить редакцию по пользователям
     */
    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    /**
     * Изменяет пароль
     */
    @PostMapping("/set_password")
    public ResponseEntity<NewPassword> setPassword(@RequestBody NewPassword newPassword) {
        return ResponseEntity.ok(newPassword);
    }

    /**
     * Выводит пользователя по id
     */
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(new User());
    }
}
