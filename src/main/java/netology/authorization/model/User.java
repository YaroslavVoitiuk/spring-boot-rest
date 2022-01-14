package netology.authorization.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;


@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Size(min = 3, max = 9)
    private String username;

    @Size(min = 3, max = 9)
    private String password;


}
