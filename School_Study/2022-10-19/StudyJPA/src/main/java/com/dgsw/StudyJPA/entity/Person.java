package com.dgsw.StudyJPA.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블 만들기
@Getter // Getter 함수
@Setter // Setter 함수
@AllArgsConstructor // 모드나라미터가 있는 생성자
@NoArgsConstructor  // 기본 생성자
@Builder    // builder 객체 생성
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}