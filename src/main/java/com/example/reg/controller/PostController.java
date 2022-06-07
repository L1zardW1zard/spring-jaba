package com.example.reg.controller;

import com.example.reg.entity.PostEntity;
import com.example.reg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostEntity post, @RequestParam Long userId){
        try{
            return ResponseEntity.ok(postService.createPost(post, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity changePost(@RequestBody PostEntity post,@RequestParam Long id){
        try{
            return ResponseEntity.ok(postService.changePost(post, id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
