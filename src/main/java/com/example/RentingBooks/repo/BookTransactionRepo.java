package com.example.RentingBooks.repo;

import com.example.RentingBooks.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTransactionRepo extends JpaRepository<BookTransaction,Integer> {
}
