package com.example.SpringSecvice.repositories;

import com.example.SpringSecvice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select * from post order by creation_date desc", nativeQuery = true)
    public List<Post> sortByDate();

    @Query(value = "select * from post where post_id=?1", nativeQuery = true)
    public Post findPostById(Long id);
}