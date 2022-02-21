package com.example.RentingBooks.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
    private String description;



}
