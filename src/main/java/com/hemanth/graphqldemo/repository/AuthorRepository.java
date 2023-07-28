package com.hemanth.graphqldemo.repository;

import com.hemanth.graphqldemo.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private List<Author> authers = new ArrayList<>();

    public List<Author> findAll() {
        return authers;
    }

    public Author findById(int id) {
        return authers.stream()
                .filter(auther -> auther.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authers.stream()
                .filter(auther -> auther.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Auther not found"));
    }

    @PostConstruct
    public void init() {
        authers.add(new Author(1, "Josh", "Long"));
        authers.add(new Author(2, "Mark", "Heckler"));
        authers.add(new Author(3, "Greg", "Turnquist"));
    }
}
