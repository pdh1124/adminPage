package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

//컨트롤러를 사용할 것이다.
@RestController
@RequestMapping("/api") //주소를 할당, class에 대한 리퀘스트맵핑에 대해 두가지가 겹치더라도 스프링부트가 실행되더라도 상관이 없다.
public class PostController {

    //POST라는 것은 어떨때 발생하냐면
    //HTML <Form>를 사용한다던지 ajax 비동기화를 할때 주로 검색에 사용
    //폼태크, 검색 사용된다는 얘기는 검색 파라미터가 많다는 것

    //http 통신을 할때 post의 body에다가 -> data를 집어 넣어서 보내겠다 라는 얘기

    //리퀘스트 할때는 폼에 여러가지 값이 있다. Json, xml, multipart-form / text-plain

    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod") 길게 쓰기 보다는 아래처럼 간단히 처리(=아래와 동일)
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) { //@RequestBody에 SearchParam searchParam를 매칭시켜 주세요.

        return searchParam;

    }
}
