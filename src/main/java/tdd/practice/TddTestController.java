package tdd.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TddTestController {
    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
}
