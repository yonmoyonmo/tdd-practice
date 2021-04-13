package tdd.practice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdd.practice.entity.UserName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//콘튜롤라 부분은 그냥 써도 테스트 코드 같긴 하군
//서비스 단에서 어떤 결과를 돌려줄 거라 예상을 하고 쓰기 때문이지
@RestController
public class TddTestController {

    private final TddTestService tddTestService;

    TddTestController(TddTestService tddTestService){
        this.tddTestService = tddTestService;
    }

    @PostMapping("/name")
    public ResponseEntity<ResponseBody> addName(
            @RequestBody UserName userName){

        ResponseBody responseBody = new ResponseBody();
        if(userName.getUserName() == null){
            responseBody.setMessage("이름이 없는데유?");
            return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.BAD_REQUEST);
        }
        UserName result = tddTestService.add(userName);
        responseBody.setData(result);
        responseBody.setMessage("된거 같은디유?");
        return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping("/name")
    public ResponseEntity<ResponseBody> list(
            @RequestParam("name") String name){

        ResponseBody responseBody = new ResponseBody();
        if(name == null){
            responseBody.setMessage("파라미터 없는디유?");
            responseBody.setData(null);
            return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.BAD_REQUEST);
        }
        if(!tddTestService.isRegistered(name)){
            responseBody.setMessage("이름이 등록된기 아닌디유?");
            responseBody.setData(null);
            return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.OK);
        }
        ArrayList<String> anagrams = tddTestService.getAnagrams(name);
        responseBody.setData(anagrams);
        responseBody.setMessage("된거 같은디유? 흠흠?;");
        return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<ResponseBody> updateName(
            @RequestBody UserName selectedUserName){

        ResponseBody responseBody = new ResponseBody();
        if(selectedUserName.getUserName() == null){
            responseBody.setMessage("등록할 이름이 없는디요?");
            responseBody.setData(null);
            return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.BAD_REQUEST);
        }
        tddTestService.updateName(selectedUserName);
        responseBody.setData(null);
        responseBody.setMessage("된거같은디유?");
        return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping("/name")
    public ResponseEntity<ResponseBody> deleteName(@RequestParam("id") long id){

        tddTestService.deleteNameById(id);

        ResponseBody responseBody = new ResponseBody();
        responseBody.setMessage("지워진듯?");
        responseBody.setData(null);
        return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.OK);
    }

}
