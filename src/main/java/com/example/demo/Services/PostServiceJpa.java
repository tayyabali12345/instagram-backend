package com.example.demo.Services;

import com.example.demo.entities.Post;
import com.example.demo.jpa.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostServiceJpa {


    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts(){
        List<Post> data = postRepository.findAll();
        return data;
    }

    public boolean deletePost(@PathVariable Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            postRepository.delete(post);
            return true;
        }
        return false;
    }

    public boolean editPost(@PathVariable("postId") Long postId,  @RequestBody Map<String, Object> request){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) {
            return false;
        }
        Post post = optionalPost.get();
        post.setContent((String) request.get("content"));
        postRepository.save(post);
        return true;
    }
}

