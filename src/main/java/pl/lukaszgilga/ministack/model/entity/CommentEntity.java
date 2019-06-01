package pl.lukaszgilga.ministack.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@Data
public class CommentEntity {
    @Id
    @GeneratedValue
    private int id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;


    @Column(name ="creation_time")
    private LocalDateTime creationTime;
}
