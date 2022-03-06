package com.example.RentingBooks.dto;

import com.example.RentingBooks.entity.Book;
import com.example.RentingBooks.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTransactionDto {
    private Integer id;
    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date todate;
    private String rentstatus;
    private Book book;
    private Member member;
    private Integer noofdays;
    private String membername;
    private String bookname;
    private Integer stockcount;
    private List<String> codelist;


}
