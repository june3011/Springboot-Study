package com.dgsw.StudyJPA.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 테이블 만들기
@Getter // Getter 함수
@Setter // Setter 함수
@AllArgsConstructor // 모드나라미터가 있는 생성자
@NoArgsConstructor  // 기본 생성자
@Builder    // builder 객체 생성
public class AA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String aa;
    private String bb;

    private LocalDateTime cdate;
    private LocalDateTime mdate;

    private int count;

}
