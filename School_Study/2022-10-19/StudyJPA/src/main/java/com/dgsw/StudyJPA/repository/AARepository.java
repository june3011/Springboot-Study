package com.dgsw.StudyJPA.repository;

import com.dgsw.StudyJPA.entity.AA;
import org.springframework.data.jpa.repository.JpaRepository;

// select, insert, update, delete 가 자동으로 만들어진다
public interface AARepository extends JpaRepository<AA, Long> {



}
