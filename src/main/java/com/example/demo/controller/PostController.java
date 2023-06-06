
package com.example.demo.controller;

import com.example.demo.Services.PersonServiceJpa;
import com.example.demo.Services.PostServiceJpa;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    private PostServiceJpa postservicejpa;


    @GetMapping("/allPosts")
    public List<Post> getCourses(){
        return this.postservicejpa.getPosts();
    }

    @DeleteMapping("post/{postId}/delete")
    public boolean deletePost(@PathVariable Long postId){
        return this.postservicejpa.deletePost(postId);
    }

    @PutMapping("post/{postId}/edit")
    public boolean editPost(@PathVariable("postId") Long postId, @RequestBody Map<String, Object> request) {
        return this.postservicejpa.editPost(postId, request);
    }
}