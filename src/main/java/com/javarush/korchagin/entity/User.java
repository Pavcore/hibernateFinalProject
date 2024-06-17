package com.javarush.korchagin.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//todo сделать класс entity

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
