package com.javarush.korchagin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Character {

    private Long id;

    private String name;

    private CharacterClass characterClass;

    private User user;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character) {
            Character equalsCharacter = (Character) obj;
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
