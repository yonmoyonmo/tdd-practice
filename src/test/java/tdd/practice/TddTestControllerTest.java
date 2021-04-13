package tdd.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tdd.practice.entity.UserName;

import static org.junit.jupiter.api.Assertions.*;

//controller test
@ExtendWith(SpringExtension.class)
@WebMvcTest(TddTestController.class)
class TddTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    void create() {
    }

    void delete() {

    }
    void list(){

    }
    void update(){

    }
}