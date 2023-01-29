package com.example.jpa.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "user_seq_gen",
        sequenceName = "user_seq"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq_gen")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public User(String name) {
        this.name = name;
    }
}
