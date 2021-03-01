package com.example.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //이 것은 레포지토리인 것을 선언 ()
public interface UserRepository extends JpaRepository<User, Long> { //JpaRepository를 상속받는다. <user의 레파지토리이고, 식별자 Long(왜냐면 user의 Id 값을 Long으로 했기 때문에)>

}
