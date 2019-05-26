package pl.lukaszgilga.ministack.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="post" )
@Data
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;

    @Column(name ="creation_time")
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "user_id")  // wskazujemy kolumne do której wrzucamy obiekt UserEntiy
    private UserEntity user;
}
