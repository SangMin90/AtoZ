package com.atoz.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotNull(message = "아이디를 반드시 입력해주세요")
    private String userId;

    @NotNull(message = "패스워드를 반드시 입력해주세요")
    private String password;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
