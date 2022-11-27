package com.atoz.authentication.help;

import com.atoz.authentication.mapper.RefreshTokenMapper;
import com.atoz.authentication.entity.RefreshTokenEntity;

import java.util.*;

public class StubRefreshTokenMapper implements RefreshTokenMapper {
    private static Map<String, RefreshTokenEntity> tokens = new HashMap<>();

    @Override
    public void saveToken(RefreshTokenEntity refreshTokenEntity) {
        tokens.put(refreshTokenEntity.getTokenKey(), refreshTokenEntity);
    }

    @Override
    public void updateToken(RefreshTokenEntity refreshTokenEntity) {
        tokens.put(refreshTokenEntity.getTokenKey(), refreshTokenEntity);
    }

    @Override
    public Optional<RefreshTokenEntity> findTokenByKey(String tokenKey) {
        return Optional.ofNullable(tokens.get(tokenKey));
    }

    @Override
    public void deleteToken(String tokenKey) {
        tokens.remove(tokenKey);
    }
}
