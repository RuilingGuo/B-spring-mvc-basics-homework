package com.thoughtworks.capacity.gtb.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;

    @NotBlank(message = "用户名不为空")
    @Size(min = 3,max = 10, message = "用户名不合法，长度应为3到10位")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$",message = "用户名不合法，用户名只能由字母、数字、下划线组成")
    private String username;
    @NotBlank(message = "密码不为空")
    @Size(min = 5, max = 12, message = "密码不合法，密码长度应为5到12位置")
    private String password;
    @Email(message = "邮箱地址不合法")
    private String email;
}
