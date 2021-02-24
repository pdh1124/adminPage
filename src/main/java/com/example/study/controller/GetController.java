package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

//이 곳은 컨트롤러로 활용할 것이라는 언어테이션
@RestController

//이곳으로 들어올 API주소를 MAPPING하기 위해서 그리고 ()안에는 어떠한 주소로 받을 것인지에 대해서 주소를 넣게 되어있다.
//api로 받을 예정이기에 api로 지정함
@RequestMapping("/api") // Localhost:8080/api까지 주소가 매칭 됨

public class GetController {

    //사용자의 요청에 의해서 한가지 메소드로 받아 들일 수 있다.
    //메소드 생성
    //리퀘스트맵핑을 통해 메소드는 GET형식으로 받고,패스는 어떠한 주소로 받아들이 겠다라는 뜻 
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // Localhost:8080/api/getMethod로 호출
    public String getRequest() {

        return "Hi getMethod";

        //http://localhost:8080/api/getMethod로 들어가 봄

    }

    //getMethod라고 하면 요청하는 주소뒤에 파라미터가 붙어 있다.
    //사용자에 요청에 의해서 어떤 요청을 들어온지 알 수 있다.


    //@GetMapping는 @RequestMapping과 다르게 메소드를 지정하지 않아도 되고 주소만설정 해주면 된다.
    @GetMapping("/getParameter") //Localhost:8080/api/getParameter로 호출
    //@RequestParam)은 Localhost:8080/api/getParameter?id=1234&password=abcd에서 id와 password 매칭을 해서 해당 값을 받아오는 것
    public String getParmeter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        //개발을 하다보면 지역내변수에서 미리 password를 사용 할 수 있음
        String password = "bbbb";

        System.out.println("id : " + id);
        System.out.println("password : " + pwd);

        return id+pwd;
    }

    //검색을 할때 여러가지 파라미터를 가져 올수 있음. 예를 들면 계정,이메일,키워드,또는 페이지라던지 여러가지 검색 파라미터를 받아야 한다.
    //localhost:8080/api/getMultiParameter?account=abcd&email=stude@gmail.com&page=10
    //검색에 대한 변수가 계속 늘어나는 상황이다.

    //@RequestParam가 계속 늘게 되면 늘어날때마다 직접 쓸 수 없기 때문에 package에 model로 만들고 자바 클래스를 만들어 받아줄 파라미터를 모아준다.
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(/*@RequestParam String account,
                                    @RequestParam String email,
                                    @RequestParam int page*/
                                    SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());


        //네트워크 통신을 할때 JSON으로 알고 있는데
        // { "account" : "", "email" : "", "page" : 0} 이런식으로 원하는데
        // 이것은 스트링부트에서 하려면 public String getMultiParameter에서 String을 자바 클래스로 만들었던
        // SearchParam으로 바꾸고 return 값도 searchParam로 바꾸면 된다.
        return searchParam;

    }


}
