package com.example.SpringSecvice.repositories;

import com.example.SpringSecvice.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}