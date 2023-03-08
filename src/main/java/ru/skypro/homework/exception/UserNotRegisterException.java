package ru.skypro.homework.exception;

public class UserNotRegisterException extends RuntimeException {
    private final String email;
    public UserNotRegisterException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
