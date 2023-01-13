package studio.thinkground.testproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.dto.MemberDto;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // http://localhost:8080/api/v1/put-api
    @PutMapping(value="default")
    public String putMethod(){
        return "hello world";
    }

    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String putMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    // http://localhost:8080/api/v1/put-api/member2  -> JSON 형태로 responsbody 반환
    @PutMapping(value = "/member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    // http://localhost:8080/api/v1/put-api/member3  -> member2와 차이는 status 200과 202
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
