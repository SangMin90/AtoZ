package com.atoz.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    LoginRequestDTO findById(String userId);
}
