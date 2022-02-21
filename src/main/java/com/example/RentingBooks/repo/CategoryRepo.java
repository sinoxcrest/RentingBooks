package com.example.RentingBooks.repo;

import com.example.RentingBooks.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
