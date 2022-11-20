package com.atoz.user;

import com.atoz.authentication.Authority;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class UserServiceTest {

    UserService userService;

    SpyStubUserMapper userMapper;

    @BeforeEach
    public void beforeEach() {
        PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        userMapper = new SpyStubUserMapper();
        userService = new UserServiceImpl(userMapper, passwordEncoder);
    }

//    @Test
//    void 올바른_아이디_비밀번호_쌍_로그인_성공() {
//        SigninDTO expectedSigninDTO = SigninDTO.builder()
//                .userId("testId")
//                .password("testPassword")
//                .build();
//
//        SigninDTO actualSigninDTO = userService.findSigninInfo(expectedSigninDTO);
//
//        assertThat(userMapper.getCallFindByIdCount()).isEqualTo(1);
//        isEquality(actualSigninDTO, expectedSigninDTO);
//    }

//    @Test
//    void 미등록_유저_아이디_로그인_실패() {
//        SigninDTO expectedSigninDTO = SigninDTO.builder()
//                .userId("testId2")
//                .password("testPassword")
//                .build();
//
//
//        assertThatThrownBy(() ->
//                userService.findSigninInfo(expectedSigninDTO))
//                .isInstanceOf(SigninFailedException.class)
//                .hasMessage("해당 유저가 존재하지 않습니다.");
//        assertThat(userMapper.getCallFindByIdCount()).isEqualTo(1);
//    }

//    @Test
//    void 틀린_아이디_로그인_쌍_실패() {
//        SigninDTO expectedSigninDTO = SigninDTO.builder()
//                .userId("testId")
//                .password("testPassword2")
//                .build();
//
//        assertThatThrownBy(() ->
//                userService.findSigninInfo(expectedSigninDTO))
//                .isInstanceOf(SigninFailedException.class)
//                .hasMessage("패스워드 값이 일치하지 않습니다.");
//        assertThat(userMapper.getCallFindByIdCount()).isEqualTo(1);
//    }

    private void isEquality(SigninDTO actual, SigninDTO expected) {
        assertThat(actual.getUserId()).isEqualTo(expected.getUserId());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
    }

    static class SpyStubUserMapper implements UserMapper {

        private int callFindByIdCount = 0;

        @Override
        public void addUser(UserEntity userEntity) {
        }

        @Override
        public void addAuthority(UserEntity userEntity) {
        }

        @Override
        public Optional<UserEntity> findById(String userId) {
            this.callFindByIdCount++;

            if (userId.equals("testId")) {
//                return SigninDTO.builder()
//                        .userId("testId")
//                        .password("testPassword")
//                        .build();

                Set<Authority> authorities = new HashSet<>();
                authorities.add(Authority.ROLE_USER);
                return Optional.ofNullable(
                        new UserEntity("testId",
                                "testPassword",
                                "testNickname",
                                "test@test.com",
                                authorities));
            } else {
                return null;
            }

        }

        public int getCallFindByIdCount() {
            return callFindByIdCount;
        }
    }
}