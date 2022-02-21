package com.example.RentingBooks.service.impl;

import com.example.RentingBooks.dto.AuthorDto;
import com.example.RentingBooks.entity.Author;
import com.example.RentingBooks.repo.AuthorRepo;
import com.example.RentingBooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public AuthorDto create(AuthorDto authorDto) {
        Author entity= Author.builder()
                .id(authorDto.getId())
                .fullname(authorDto.getFullname())
                .email(authorDto.getEmail())
                .mobileno(authorDto.getMobileno())
                .build();
        entity=authorRepo.save(entity);
        return authorDto.builder().
                id(entity.getId())
                .fullname(entity.getFullname())
                .email(authorDto.getEmail())
                .mobileno(authorDto.getMobileno())
                .build();
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authorList = authorRepo.findAll();
        return authorList.stream().map(entity -> AuthorDto.builder()
                .id(entity.getId())
                .fullname(entity.getFullname())
                .email(entity.getEmail())
                .mobileno(entity.getMobileno())
                .build()).collect(Collectors.toList());
    }

    @Override
    public AuthorDto findById(Integer id) {
        return null;
    }
}
