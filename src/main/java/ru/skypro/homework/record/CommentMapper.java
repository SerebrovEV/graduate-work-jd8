package ru.skypro.homework.record;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.model.CommentEntity;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", source = "pk")
    @Mapping(target = "user.id", source = "author")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    CommentEntity dtoToModel(Comment comment);
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "user.id")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Comment modelToDto(CommentEntity commentEntity);

    List<CommentEntity> dtoToModel(List<Comment> comments);
    List<Comment> modelToDto (List<CommentEntity> comments);

}
