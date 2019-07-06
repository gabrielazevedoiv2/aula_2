package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
