package com.example.SpringSecvice.repositories;

import com.example.SpringSecvice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select * from comment where post_post_id=?1 order by date desc", nativeQuery = true)
    public List<Comment> sortByDate(Long id);
}