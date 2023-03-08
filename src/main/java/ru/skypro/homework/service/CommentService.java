package ru.skypro.homework.service;

import ru.skypro.homework.dto.Comment;

public interface CommentService {

    Comment addComment(Integer id, Comment comment);

    Comment updateComment(Comment comment);

    Comment getComment(Integer id);

    void deleteComment(Integer id);
}
