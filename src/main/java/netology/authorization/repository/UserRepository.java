package netology.authorization.repository;

import netology.authorization.exception.InvalidCredentials;
import netology.authorization.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, String> users = new HashMap<>();

    public UserRepository() {
        users.put("user", "qwerty123");
        users.put("admin", "admin");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> emptyList = new ArrayList<>();
        switch (user) {
            case "user":
                if (users.containsKey(user)) {
                    if (users.get(user).equals(password)) {
                        return List.of(Authorities.READ);
                        //} else return emptyList;
                    } else throw new InvalidCredentials("Wrong password for user");
                }
            case "admin":
                if (users.containsKey(user)) {
                    if (users.get(user).equals(password)) {
                        return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
                        //} else return emptyList;
                    } else throw new InvalidCredentials("Wrong password for admin");
                }
            default: return emptyList;
        }
    }
}
