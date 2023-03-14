package ru.skypro.homework.exception;

public class UserNotForbiddenException extends RuntimeException {
    private final int id;

    public UserNotForbiddenException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
