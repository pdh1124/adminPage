package com.example.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
    
    //사용자로 부터 접속을 받아주기 위해서 주소를 설정해줘야 합니다.
    //그러한 주소들을 묶어두는 것을 컨트롤러라고 합니다.
    //그래서 package로 controller를 만듦
}
