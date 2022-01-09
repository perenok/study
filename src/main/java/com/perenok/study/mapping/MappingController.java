package com.perenok.study.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    @PostMapping("/mapping/model")
    public ResponseEntity<Void> createWithModel(@ModelAttribute ModelRequest request){
        System.out.println("model 테스트 => " + request.getName() + " : " + request.getAge());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mapping/body")
    public ResponseEntity<Void> createWithRequestBody(@RequestBody BodyRequest request){
        System.out.println("body 테스트 => " + request.getName() + " : " + request.getAge());
        return ResponseEntity.ok().build();
    }
}
