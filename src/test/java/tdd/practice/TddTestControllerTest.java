package tdd.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import tdd.practice.entity.UserName;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

//controller test
//@WebMvcTest(TddTestController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TddTestControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private TddTestController testController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @Transactional
    void addName() throws URISyntaxException {
        String endPoint = "http://localhost:"+port+"/name";
        URI uri = new URI(endPoint);
        UserName newName = new UserName("wonmo");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserName> request = new HttpEntity<>(newName, headers);

        ResponseEntity<UserName> result = testRestTemplate.postForEntity(uri, request, UserName.class);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
    //아이 이정도 하고 말아야지
    //컨트롤러 테스트는 별 의미가 엄꾼
    //복잡한 무엇 아니면 그냥 테스트 코드 짤 필요가 없을지도...?
    @Test
    void list() {
    }

    @Test
    void updateName() {
    }

    @Test
    void deleteName() {
    }
}