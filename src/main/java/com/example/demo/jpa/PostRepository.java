package com.example.demo.jpa;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
