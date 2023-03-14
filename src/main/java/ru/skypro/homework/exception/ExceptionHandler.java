package ru.skypro.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AdsNotFoundException.class)
    public ResponseEntity<String> handleAdsNotFoundException(AdsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(String.format("Объявление c id = %d  не найдено", e.getId()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotRegisterException.class)
    public ResponseEntity<String> handleUserNotRegisterException(UserNotRegisterException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(String.format("Пользователь %s не зарегистрирован", e.getEmail()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<String> handleCommentsNotFoundException(CommentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(String.format("Комментарий c id = %d  не найдено", e.getCommentId()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotForbiddenException.class)
    public ResponseEntity<String> handleUserNotForbiddenException(UserNotForbiddenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(String.format("Пользователю c id = %d  запрещено редактировать комментарий", e.getId()));
    }
}
