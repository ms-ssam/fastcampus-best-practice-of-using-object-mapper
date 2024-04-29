package com.example.objectmapper;

import com.example.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("###########################################");

        //text 형태의 Json -> object / object -> text Json
        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper 특 1) obj -> Json text 할 때 object mapper는 get method 참조
        // => 작성하는 클래스가 obj mapper에서 쓰인다면 메서드 작성할 때 get~로 작명 X!
        var user = new User("steve", 24, "010-1111-2222");
        String text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper 특 2) Json text -> obj 동작하기 위해서 기본 생성자 필요
        // ObjectMapper.readValue(Json text, 변환할 클래스)
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
