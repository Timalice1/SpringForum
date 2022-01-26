package com.example.SpringSecvice.repositories;

import com.example.SpringSecvice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}