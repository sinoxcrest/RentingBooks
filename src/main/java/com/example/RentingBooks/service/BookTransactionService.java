package com.example.RentingBooks.service;

import com.example.RentingBooks.dto.BookTransactionDto;

import java.text.ParseException;
import java.util.List;

public interface BookTransactionService {
    BookTransactionDto create(BookTransactionDto bookTransactionDto);

    List<BookTransactionDto> findAll();

    BookTransactionDto findById(Integer id);

    void deleteById(Integer id);







}
