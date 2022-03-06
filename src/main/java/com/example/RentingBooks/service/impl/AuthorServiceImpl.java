package com.example.RentingBooks.service.impl;

import com.example.RentingBooks.dto.AuthorDto;
import com.example.RentingBooks.entity.Author;
import com.example.RentingBooks.entity.Book;
import com.example.RentingBooks.repo.AuthorRepo;
import com.example.RentingBooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromName;

    @Value("${spring.mail.password}")
    private String password;
    @Override
    public AuthorDto create(AuthorDto authorDto) {
        Author entity= Author.builder()
                .id(authorDto.getId())
                .firstname(authorDto.getFirstname())
                .lastname(authorDto.getLastname())
                .email(authorDto.getEmail())
                .mobileno(authorDto.getMobileno())
                .build();
        entity=authorRepo.save(entity);
        return authorDto.builder().
                id(entity.getId())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .mobileno(entity.getMobileno())
                .build();
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authorList = authorRepo.findAll();
        return authorList.stream().map(entity -> AuthorDto.builder()
                .id(entity.getId())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .mobileno(entity.getMobileno())
                .build()).collect(Collectors.toList());
    }

    @Override
    public AuthorDto findById(Integer id) {
        return null;
    }

    @Override
    public void sendEmail(AuthorDto authorDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromName);
        message.setTo(authorDto.getEmail());
        authorDto.setMessage("Your account has been created successfully");
        message.setText(authorDto.getMessage());
        mailSender.send(message);
        System.out.println("Successfully sent!!");
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Author> optionalAuthor=authorRepo.findById(id);
        if(optionalAuthor.isPresent()) {
            authorRepo.deleteById(id);
        }
    }
}
