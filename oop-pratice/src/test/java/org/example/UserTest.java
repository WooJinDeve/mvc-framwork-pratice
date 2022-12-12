package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest(){
        //given
        User user = new User();

        //when
        user.initPassword(() -> "abcdefgh");

        //then
        Assertions.assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2(){
        //given
        User user = new User();

        //when
        user.initPassword(() -> "ab");

        //then
        Assertions.assertThat(user.getPassword()).isNull();
    }

}