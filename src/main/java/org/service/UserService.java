package org.service;

import org.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer, User> users;

    public UserService() {
        users = new HashMap<>();
        User user1 = new User();
        user1.setId(1);
        user1.setLastName("Rajasekhar");
        user1.setLastName("Karampudi");

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Raj");
        user2.setLastName("Kumar");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    public User findUser(Integer id) {
        return users.get(id);
    }

    public User addUser(User user) {
        return users.put(user.getId(), user);
    }

    public User updateUser(User user) {
        User validUser = users.get(user.getId());
        if(validUser != null) {
            validUser.setFirstName(user.getFirstName());
            validUser.setLastName(user.getLastName());
        }
        return validUser;
    }

    public User deleteUser(Integer id) {
        User user = users.get(id);
        if(user != null) {
            users.remove(id);
        }
        return user;
    }
}
