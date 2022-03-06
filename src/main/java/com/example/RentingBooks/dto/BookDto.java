package com.example.RentingBooks.dto;

import com.example.RentingBooks.entity.Author;
import com.example.RentingBooks.entity.Category;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String name;
    private Integer noofpages;
    private String isbn;
    private Integer rating;
    private Integer stockcount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publisheddate;
    private String filepath;
    private MultipartFile multipartFile;
    private Category category;
    private Integer categoryid;
    private String categoryname;
    private List<Integer> authorList;
    private List<Author> authorDtoList;
    private String authorname;


}
