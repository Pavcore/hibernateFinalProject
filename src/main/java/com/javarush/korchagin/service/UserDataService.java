package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.User;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class UserDataService {
    private static UserDataService userDataService;
    @Getter
    private final UserService userService = new UserService(new UserRepository());
    private final AtomicLong atomicLong = new AtomicLong();

    private UserDataService() {
    }

    public static UserDataService getInstance() {
        if (userDataService == null) {
            userDataService = new UserDataService();
        }
        return userDataService;
    }

    public boolean authorize(User user) {
        for (User user1 : userService.getAll()) {
            if (user.getPassword().equals(user1.getPassword()) && user.getLogin().equals(user1.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public UserService fillBase() {
        if (userService.getAll().isEmpty()) {
            User userKhmelov = new User();
            userKhmelov.setLogin("alexandr_khmelov");
            userKhmelov.setPassword("java_rush");
            userService.create(userKhmelov);
            User pavelKorchagin = new User();
            pavelKorchagin.setLogin("pavel_korchagin");
            pavelKorchagin.setPassword("usEr123!75");
            userService.create(pavelKorchagin);
        }
        return userService;
    }

    public long increaseAtomic() {
        return atomicLong.getAndIncrement();
    }
}
