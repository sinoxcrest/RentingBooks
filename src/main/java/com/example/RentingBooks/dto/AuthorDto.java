package com.example.RentingBooks.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Integer id;
    private String fullname;
    private String email;
    private String mobileno;
}
