package netology.authorization.controller;

import netology.authorization.exception.InvalidCredentials;
import netology.authorization.exception.UnauthorizedUser;
import netology.authorization.model.Authorities;
import netology.authorization.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    String handleInvalidCredentials(InvalidCredentials err){
        return "ERROR: " + err.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    String handleUnauthorizedUser(UnauthorizedUser err){
        err.printStackTrace();
        return "ERROR: " + err.getMessage();
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}
