package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.model.UserEntity;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "regDate", target = "regDate")
    @Mapping(source = "adminRole", target = "adminRole")
    UserEntity toEntity(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "regDate", target = "regDate")
    @Mapping(source = "image", target = "image")
    User toDTO(UserEntity userEntity);

    Collection<UserEntity> toEntityList(Collection<User> user);

    Collection<User> toUserList(Collection<UserEntity> userEntities);


}
