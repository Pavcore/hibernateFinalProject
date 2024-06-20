package com.javarush.korchagin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "quest")
public class Quest {
    @Id
    private Long id;
    @Column(name = "main_text")
    private String mainText;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Column(name = "wrong_answer")
    private String wrongAnswer;
    @Column(name = "loose_text")
    private String looseText;
}
