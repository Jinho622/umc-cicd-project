package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // @Query <- 복잡할 때 쿼리 직접 써주어도 됨
    // List<Member> findByAgeGreaterThanAndNameIs(Integer age, String name);
}
