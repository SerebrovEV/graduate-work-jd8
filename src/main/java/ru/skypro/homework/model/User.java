package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date regDate;
    private boolean adminRole;

  //  private List<Ads> adsList;
  @OneToMany(mappedBy = "user")
  private Collection<CommentEntity> commentEntities;
}
