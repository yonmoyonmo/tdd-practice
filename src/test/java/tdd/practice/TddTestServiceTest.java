package tdd.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //이러면 그냥 통합 테스트인가?
class TddTestServiceTest {

    @Autowired
    private TddTestService tddTestService;

    @Test
    void getAnagramsTest() {
        //given
        String givenName = "wonmocyberschool";

        ArrayList<String> result = new ArrayList<>();

        //when
        result = tddTestService.getAnagrams(givenName);

        //then : 0번 : wonmo, 1, 2, 3 번 각 달라야 함.
        Boolean success = (result.get(1) != result.get(2)
                && result.get(1) != result.get(3)
                && result.get(2) != result.get(3));


        assertEquals("wonmocyberschool", result.get(0));
        assertEquals(true,success);
    }
}