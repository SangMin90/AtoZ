package com.atoz.security.authentication.helper;

import com.atoz.security.authentication.dto.SignoutDTO;
import com.atoz.security.authentication.dto.TokenRequestDTO;
import com.atoz.security.authentication.dto.TokenResponseDTO;
import com.atoz.security.authentication.AuthenticationService;
import com.atoz.security.authentication.dto.SigninDTO;

public class StubAuthenticationService implements AuthenticationService {

    @Override
    public TokenResponseDTO signin(SigninDTO signinDTO) {
        return null;
    }

    @Override
    public void signout(SignoutDTO signoutDTO) { }

    @Override
    public TokenResponseDTO refresh(TokenRequestDTO tokenRequestDTO) {
        return null;
    }
}