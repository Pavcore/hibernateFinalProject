package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.dto.CharacterClass;
import com.javarush.korchagin.entity.Character;
import com.javarush.korchagin.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.stream.Stream;

public class CharacterService {
    private final CharacterRepository characterRepository = new CharacterRepository();
    private final UserRepository userRepository = new UserRepository();

    public boolean save(HttpServletRequest req, HttpSession session) {
        String login = (String) session.getAttribute("login");
        User currentUser = userRepository.find(User.builder()
                        .login(login)
                        .build()).findFirst().orElse(null);
        String classOfCharacter = req.getParameter("characterClass");
        String nameOfCharacter = req.getParameter("characterName");
        Character character = Character.builder()
                .name(nameOfCharacter)
                .characterClass(CharacterClass.getClass(classOfCharacter))
                .user(currentUser)
                .build();
        if (findByName(character.getName()) == null) {
            characterRepository.create(character);
            return true;
        } else {
            String incorrectData = "this name is already taken";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/home.jsp");
            return false;
        }
    }

    private Character findByName(String name) {
        Stream<Character> characterStream = characterRepository.find(Character.builder()
                .name(name)
                .build());
        return characterStream.findFirst().orElse(null);
    }

    public boolean haveCharacterCreated(HttpServletRequest req, HttpSession session) {
        Character character = findByName(req.getParameter("createCharacter"));
        String login = session.getAttribute("login").toString();
        User user = userRepository.find(User.builder()
                        .login(login)
                        .build()).findFirst().orElse(null);
        List<Character> characterList = characterRepository.getAllCurrentUserCharacters(user != null ? user.getId() : null);
        if (characterList.contains(character)) {
            return true;
        } else {
            String incorrectData = "you didn't create this character";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/home.jsp");
            return false;
        }
    }
}
