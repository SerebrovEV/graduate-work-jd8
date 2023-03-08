package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    //    private Integer userId;
    @OneToMany(mappedBy = "ads")
    private Collection<CommentEntity> commentEntities;

}
