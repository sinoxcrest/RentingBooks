package com.example.RentingBooks.repo;

import com.example.RentingBooks.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}