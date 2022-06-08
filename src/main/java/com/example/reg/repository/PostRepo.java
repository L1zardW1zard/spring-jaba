package com.example.reg.repository;

import com.example.reg.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<PostEntity, Long> {
}
