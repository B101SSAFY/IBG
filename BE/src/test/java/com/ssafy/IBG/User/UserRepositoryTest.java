package com.ssafy.IBG.User;

import com.ssafy.IBG.User.Repository.UserRepository;
import com.ssafy.IBG.User.domain.User;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 생성")
    void 유저생성() {
        //given
        User user = createUser();
        userRepository.save(user);

        // when
        List<User> userList = userRepository.findAll();

        // then
        assertThat(userList.contains(user)).isTrue();
    }

    @Test
    void 유저삭제() throws Exception {
        //given
        User user = createUser();
        userRepository.save(user);

        //when
        userRepository.delete(user);

        //then
        assertThat(userRepository.findAll().contains(user)).isTrue();
    }

    private User createUser(){
        return User.builder()
                .nick("유저생성테스트")
                .email("kwak0568@naver.com")
                .pwd("1234")
                .build();
    }

}
