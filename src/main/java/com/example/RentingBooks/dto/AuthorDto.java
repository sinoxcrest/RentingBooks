package com.example.RentingBooks.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Integer id;
  //  @NotEmpty(message = "User's first name cannot be empty.")
    private String firstname;
    //@NotEmpty(message = "User's last name cannot be empty.")
    private String lastname;
   // @NotEmpty(message = "User's email cannot be empty.")
   // @Email
    private String email;
    private String mobileno;
    private String message;
}
