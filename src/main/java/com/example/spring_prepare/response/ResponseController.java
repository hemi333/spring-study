package com.example.spring_prepare.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// RestController 미사용
@Controller
@RequestMapping("/response")
public class ResponseController {
    // [Response header]
    //  Content-Type: text/html
    // [Response body]
    //  {"name":"hyemi","age":92}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // [Response header]
    //  Content-Type: application/json
    // [Response body]
    //  {"name":"hyemi","age":92}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}
