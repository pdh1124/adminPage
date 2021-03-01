package com.example.study.model.entity;




import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
//import javax.persistence.Table;
//import javax.persistence.Column;

@Data //객체로 사용할 것이기 때문에 기본생성자와 변수에 대해서 get,set의 메소드를 만들어 주고
@AllArgsConstructor //모든 매개변수르 가지는 생성자까지 추가


@Entity
//@Table(name="user") //이것은 entity지만 클래스의 이름과 테이블의 이름이 서로 동일하다면 굳이 테이블이라는것을 선언하지 않아도 됨
public class User { //User의 이름은 DB에 Table과 이름이 동일 하면 됨

    @Id //식별자에 대한것은 @Id를 붙여줘야 함
    @GeneratedValue(strategy = GenerationType.IDENTITY) //어떤식으로 관리할것인가에 대해 전력을 설정
    //strategy(전략) GenerationType(어떤 타입인지) IDENTITY(MySQL을 사용하기 때문에 사용)
    private Long id;

    private String account;

    private String email;

    //@Column (name="phone_number") //변수의 이름과 컬럼의 이름이 동일 하다고 하면 선언하지 않아도 됨
    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public User() {

    }

    /*
    자바에서 DB로 연결할 때 MySQL에서는 Snake Case로 작성을 하고 자바에서늕 camel Case로 작성을 해도
    JPA에서 자동으로 매칭을 해주기 때문에 따로 변수를 (phoneNumber를 phone_number) 수정해주기 않아도 매칭을 해준다.
     */


}
