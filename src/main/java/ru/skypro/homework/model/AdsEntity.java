package ru.skypro.homework.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ads")
public class AdsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="author_id")
    private UserEntity author;

   // private List<Comment> comments;

}
