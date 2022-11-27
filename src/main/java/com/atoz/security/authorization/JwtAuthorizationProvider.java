package com.atoz.security.authorization;

import com.atoz.error.exception.InvalidTokenException;
import com.atoz.security.token.RefreshTokenEntity;
import com.atoz.security.token.RefreshTokenMapper;
import com.atoz.security.token.TokenParser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class JwtAuthorizationProvider {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenParser tokenParser;
    private final RefreshTokenMapper refreshTokenMapper;

    public Authentication authorizeBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        String jwt = tokenParser.resolveBearerToken(bearerToken);

        return authorize(jwt);
    }

    // 사용자 아이디에 해당하는 리프레시 토큰이 서버에 저장되어 있다면 유효한 토큰이다.
    private Authentication authorize(String jwt) {
        Authentication authentication = tokenParser.parseAuthentication(jwt);

        RefreshTokenEntity refreshTokenEntity = refreshTokenMapper.findTokenByKey(authentication.getName())
                .orElseThrow(() -> new InvalidTokenException("로그아웃된 사용자입니다."));
        if (!refreshTokenEntity.getTokenValue().equals(jwt)) {
            throw new InvalidTokenException("토큰이 일치하지 않습니다.");
        }

        return authentication;
    }

    public Authentication authorize(String accessToken, String refreshToken) {
        Authentication authentication = tokenParser.parseAuthentication(accessToken);

        RefreshTokenEntity refreshTokenEntity = refreshTokenMapper.findTokenByKey(authentication.getName())
                .orElseThrow(() -> new InvalidTokenException("로그아웃된 사용자입니다."));
        if (!refreshTokenEntity.getTokenValue().equals(refreshToken)) {
            throw new InvalidTokenException("토큰이 일치하지 않습니다.");
        }

        return authentication;
    }
}