package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.model.CommentEntity;
import ru.skypro.homework.record.CommentMapper;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public Comment addComment(Integer id, Comment comment){
        CommentEntity newComment = commentMapper.dtoToModel(comment);
       // newComment.setAds();
        commentRepository.save(newComment);
        return commentMapper.modelToDto(newComment);
    }

    public Comment updateComment(Comment comment){
         commentRepository.save(commentMapper.dtoToModel(comment));
        return null;
    }

    public Comment getComment(Integer id){
        return null;
    }

    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
    }
}
