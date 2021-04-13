package tdd.practice;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody {
    private String message;
    private Object data;
    ResponseBody(){
        this.message="";
        this.data = null;
    }
    ResponseBody(String message){
        this.message=message;
    }
}
