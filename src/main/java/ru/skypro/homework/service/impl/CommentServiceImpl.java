package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.ResponseWrapperComment;
import ru.skypro.homework.exception.AdsNotFoundException;
import ru.skypro.homework.exception.CommentNotFoundException;
import ru.skypro.homework.exception.UserNotRegisterException;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.model.CommentEntity;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.CommentService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    @Override
    public Comment addComment(Integer id, Comment comment, Authentication authentication) {

        CommentEntity newComment = commentMapper.dtoToModel(comment);
        newComment.setAds(adsRepository.findById(id)
                .orElseThrow(() -> new AdsNotFoundException(id)));
        newComment.setUser(userRepository.findUserEntityByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotRegisterException(authentication.getName())));
        newComment.setCreatedAt(LocalDateTime.now());
        return commentMapper.modelToDto(commentRepository.save(newComment));
    }

    @Override
    public Comment updateComment(Integer adId, Integer commentId, Comment comment) {
        CommentEntity findComment = findComment(adId, commentId);
        findComment.setText(comment.getText());
        findComment.setCreatedAt(LocalDateTime.parse(comment.getCreatedAt(), dateTimeFormatter));
        commentRepository.save(findComment);
        return commentMapper.modelToDto(findComment);
    }

    @Override
    public Comment getComment(Integer adId, Integer commentId) {
        return commentMapper.modelToDto(findComment(adId, commentId));
    }

    @Override
    public void deleteComment(Integer adId, Integer commentId) {
        findComment(adId, commentId);
        commentRepository.deleteById(commentId);
    }

    @Override
    public ResponseWrapperComment getAllCommentsByAd(Integer id) {
        List<CommentEntity> comments = commentRepository.findAllByAds_Id(id);
        ResponseWrapperComment findComments = new ResponseWrapperComment();
        findComments.setResults(commentMapper.modelToDto(comments));
        findComments.setCount(comments.size());
        return findComments;
    }

    private CommentEntity findComment(Integer adId, Integer commentId) {
        return commentRepository.findByAds_IdAndId(adId, commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
    }
}
