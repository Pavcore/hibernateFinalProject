package com.javarush.korchagin.entity;

import com.javarush.korchagin.dto.CharacterClass;
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
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "character_class")
    @Enumerated(value = EnumType.STRING)
    private CharacterClass characterClass;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character equalsCharacter) {
            return this.name.equals(equalsCharacter.name) && this.characterClass.equals(equalsCharacter.characterClass);
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.characterClass.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Имя - %s, класс - %s", name, characterClass);
    }
}
