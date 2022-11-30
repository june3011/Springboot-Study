package com.example.jun_board.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor  // 매개변수 없는 생성자
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    private String writter;
    private String title;
    private String content;

    @CreationTimestamp
    private LocalDateTime wdate;    // 작성일자

    private int viewCount;

}
