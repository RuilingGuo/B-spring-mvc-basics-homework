package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @NotNull
    @Size(min = 3,max = 10)
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$")
    private String username;
    @NotNull
    @Size(min = 5, max = 12)
    private String password;
    @NotNull
    @Email
    private String email;
}
