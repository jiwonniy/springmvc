package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
//@Controller @ResponseBody
@RestController //@RestController는 ResponseBody가 포함되어 있기 때문에 우리가 만든 json-v2 형식을 많이 사용한다.
public class ResponseBodyController {

    //공부했던 내용들을 쭉 정리

    //서블릿을 직접 다룰 때처럼 HttpServletResponse 객체를 통해서 http 메시지바디에 직접 ok 메시지 전달
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
    response.getWriter().write("ok");
    }

    //ResponseEntity는 HTTP 응답 코드를 설정할 수 있음
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    //@ResponseBody를 사용해서 view를 사용하지 않음
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    //JSON 을 처리할 때!
    //@ResponseEntity를 반환하고, HTTP 메시지 컨버터를 통해서 JSON 형식으로 변환되어 반환
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    //api만들 때 이런 스타일로 많이 만듦
    @ResponseStatus(HttpStatus.OK) //응답 코드도 설정할 수 있음
    //@ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }
}
