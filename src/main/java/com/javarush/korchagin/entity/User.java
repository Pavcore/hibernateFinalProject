package com.javarush.korchagin.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;

    private String login;

    private String password;

    private List<Character> characters;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
