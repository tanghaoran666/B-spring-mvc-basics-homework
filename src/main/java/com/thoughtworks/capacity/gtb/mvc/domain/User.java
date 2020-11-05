package com.thoughtworks.capacity.gtb.mvc.domain;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @NotNull(message = "username must not be null")
    @Size(min = 3, max = 10, message = "the username is illegal")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "the username is illegal")
    private String username;
    @NotNull(message = "password must not be null")
    @Size(min = 5, max = 12, message = "the password is illegal")
    private String password;
    @Email(message = "the email is illegal")
    private String email;
//

}
