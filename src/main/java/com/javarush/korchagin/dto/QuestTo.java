package com.javarush.korchagin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestTo {
    Long id;
    String mainText;
    String correctAnswer;
    String wrongAnswer;
    String looseText;
}
