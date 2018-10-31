package com.playcoin.usrmgnt.controller;

import com.playcoin.usrmgnt.user.domain.User;
import com.playcoin.usrmgnt.user.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
//    private TestRestTemplate restTemplate;
    private UserRepository userRepository;

    @Test
    public void saveUser() {
            //given
            userRepository.save(User.builder()
                    .userId("userId")
                    .email("email")
                    .name("name")
                    .nickName("nickName")
                    .regDate(LocalDate.now())
                    .build());

            //when
            List<User> userList = userRepository.findAll();

            //then
            User users = userList.get(0);

            assertThat(users.getId(),is(1L));
            assertThat(users.getUserId(), is("userId"));
            assertThat(users.getEmail(),is("email"));

        }

//    @Test
//    public void 메인페이지_로딩() {
//        //when
//        String body = this.restTemplate.getForObject("/", String.class);
//
//        //then
//        assertThat(body).contains("Playcoin User Management");
//    }
}
