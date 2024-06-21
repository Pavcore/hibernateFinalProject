package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.Character;
import com.javarush.korchagin.entity.CharacterClass;
import com.javarush.korchagin.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.stream.Stream;

//todo добавить метод для выборки персонажей определенного пользователя

public class CharacterService {
    private final CharacterRepository characterRepository = new CharacterRepository();

    public boolean save(HttpServletRequest req, HttpSession session) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService();
        String login = (String) session.getAttribute("login");
        User currentUser = userService.findUserByUsername(login);
        String classOfCharacter = req.getParameter("characterClass");
        String nameOfCharacter = req.getParameter("characterName");
        Character character = Character.builder()
                .name(nameOfCharacter)
                .characterClass(CharacterClass.getClass(classOfCharacter))
                .user(currentUser)
                .build();
        if (findByName(character.getName()) == null) {
            currentUser.getCharacters().add(character);
            userRepository.update(currentUser);
            GameService gameData = GameService.getInstance();
            gameData.increaseGameAmount();
            return true;
        } else {
            String incorrectData = "this name is already taken";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/home.jsp");
            return false;
        }
    }

    private Character findByName(String name) {
        Stream<Character> characterStream = characterRepository.find(Character.builder().name(name).build());
        return characterStream.findFirst().orElse(null);
    }

    public boolean haveCharacterCreated(HttpServletRequest req, HttpSession session) {
        UserService userService = new UserService();
        Character character = findByName(req.getParameter("createCharacter"));
        User user = userService.findUserByUsername(session.getAttribute("login").toString());
        if (user.getCharacters().contains(character) && character!=null) {
            GameService gameData = GameService.getInstance();
            gameData.increaseGameAmount();
            return true;
        } else {
            String incorrectData = "you didn't create this character";
            session.setAttribute("incorrectData", incorrectData);
            session.setAttribute("jspPath", "/home.jsp");
            return false;
        }
    }
}
