package com.thoughtworks.capacity.gtb.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @NotNull
    @Size(min = 3, max = 10)
    private String username;
    @NotNull
    @Size(min = 5, max = 12)
    private String password;
    @Email
    private String email;
//    @Pattern(regexp = "1\\d{10}")

}
