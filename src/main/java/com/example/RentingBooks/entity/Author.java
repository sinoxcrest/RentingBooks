package com.example.RentingBooks.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_author")

public class Author implements Serializable {
    @Id
    @SequenceGenerator(name="author_sequence",initialValue = 1,sequenceName = "author_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_sequence")
    private Integer id;
    @Column(name="fullname",length = 100)
    private String fullname;
    @Column(name="email",length = 100,unique = true)
    private String email;
    @Column(name="mobileno",length = 10,unique = true)
    private String mobileno;
}
