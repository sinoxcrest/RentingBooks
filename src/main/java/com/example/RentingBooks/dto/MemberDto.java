package com.example.RentingBooks.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String mobileno;
}
