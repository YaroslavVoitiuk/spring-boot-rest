package netology.authorization.repository;

import netology.authorization.exception.InvalidCredentials;
import netology.authorization.model.Authorities;
import netology.authorization.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, String> users = new HashMap<>();

    public UserRepository() {
        users.put("user", "qwerty123");
        users.put("admin", "admin");
    }

public List<Authorities> getUserAuthorities(User user) {
    List<Authorities> emptyList = new ArrayList<>();
    switch (user.getUsername()) {
        case "user":
            if (users.containsKey(user.getUsername())) {
                if (users.get(user.getUsername()).equals(user.getPassword())) {
                    return List.of(Authorities.READ);
                } else throw new InvalidCredentials("Wrong password for user");
            }
        case "admin":
            if (users.containsKey(user.getUsername())) {
                if (users.get(user.getUsername()).equals(user.getPassword())) {
                    return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
                } else throw new InvalidCredentials("Wrong password for admin");
            }
        default: return emptyList;
    }
}
}
