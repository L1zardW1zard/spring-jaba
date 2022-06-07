package com.example.reg.model;

import com.example.reg.entity.PostEntity;

public class Post {
    private Long id;
    private String title;
    private String text;

    public static Post toModel(PostEntity entity){
        Post model = new Post();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setText(entity.getText());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post() {
    }
}
