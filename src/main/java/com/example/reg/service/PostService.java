package com.example.reg.service;

import com.example.reg.entity.PostEntity;
import com.example.reg.entity.UserEntity;
import com.example.reg.model.Post;
import com.example.reg.repository.PostRepo;
import com.example.reg.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    public Post createPost(PostEntity post,Long userId){
        //PostEntity newPost = new PostEntity();
        UserEntity user = userRepo.findById(userId).get();
        post.setUser(user);
        //newPost.setUser(user);
        //newPost.setTitle(post.getTitle());
        //newPost.setText(post.getText());
        return Post.toModel(postRepo.save(post));
    }

    public Post changePost(PostEntity post, Long id){
        PostEntity newPost = postRepo.findById(id).get();
        newPost.setTitle(post.getTitle());
        newPost.setText(post.getText());
        return Post.toModel(postRepo.save(newPost));
    }

    public Long delete(Long id) {
        postRepo.deleteById(id);
        return id;
    }
}
