package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;



import java.time.LocalDateTime;
import java.util.Optional;

@Test
public class UserRepositoryTest extends StudyApplicationTests {

    //레파지토리로 CRUD를 테스트 할것이기 때문에
    @Autowired
    //private UserRepository userRepository = new UserRepository;
    //보통 기본적으로 자바를 코딩한다고 하면 new를 써서 직접 객체를 만들어서 userRepository를 이용해서 (16줄로)
    //@Autowired란 스프링에 가장 큰 장점이기도 한 대표적인 디자인 패턴으로 우리가 얘기하는 DI라고 얘기한다. 스프링은 DI를 빼놓을 수 없는데
    //DI(Dependency Injection)이라고 해서 간단하게 이야기 하면 의존성의 주입이다.
    //그래서 우리가 직접 객체를 만들지 않고 이러한 객체들을 스프링에서 직접 관리하겠다는 뜻이다.
    //그리고 스프링이 이러한 의존성들을 주입시켜 주겠다라고 해서 DI(Dependency Injection)라고 한다.
    //@Autowired 라는 키워드로 주입을 받겠다
    private UserRepository userRepository;

   //CRUD 만들기

    //그냥 실행시키면 안되고 테스트 코드이기 때문에 @Test 언논테이션을 만들어 줘야함
    @Test
    public void create() {
        //userRepository.save();
        //직접 save()를 하던지 지원하는 메소드를 주로 사용을 했다.

        // String sql = insert into user(%s, %s, %d) value (account, email, age); 라고 넣었었는데
        User user = new User();
        //user.setId(); //AI(Auto Incremental)이기 때문에 자동으로 데이터베이스에서 순차적으로 번호를 올릴것이기 때문에 값을 넣지 않아도 된다.
        user.setAccount("TestUser03");
        user.setEmail("testUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");
        //User는 DI로 관리하지 않느냐는 얘기를 할 수 있는데
        //DI의 기본 핵심은 싱글톤이다.
        //싱글톤이란 userRepository를 하나만 생성을 해두고 @Autowired라는 곳에다가 다같이 쓰겠다 라고 하기때문에
        //user는 매번 생성할때마다 값이 달라져야 하기도 하고 우리가 만드는 값이기 때문에 user에 각각 다른 값어 가기 때문에
        //직접 선언해서 사용한다.

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }


    //예를 들어 Id를 받아 리턴시켜주어 표시해 줄수 있다.
    @Test
    public void read() {
        //userRepository.findAll() //데이터의 있는 것을 리스트로 모두 가져오겠다.
        Optional<User> user = userRepository.findById(2L); //() 값의 Id를 가져오겠다. 2L = 2번째를 가져오는데 L은 Long타입이기 때문에


        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("user : " + selectUser.getEmail());
        });
    }


    //update를 하기 위해선 특정 데이터를 셀렉트 해야 한다.
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            //반드시 update를 치기 위해 마지막에 userRepository에 해당 유저를 save를 해주어야 한다.
            userRepository.save(selectUser);

            //create때도 객체를 만들고 세이브를 했는데 새로운 유저가
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(2L);

        //2L 이라는 것을 셀렉터를 했을때 반드시 데이터가 존재해야하기 때문에


        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if(deleteUser.isPresent()) {
            System.out.println("데이터 존재" + deleteUser.get());
        } else {
            System.out.println("데이터 삭제, 데이터 없음");
        }

    }

}
