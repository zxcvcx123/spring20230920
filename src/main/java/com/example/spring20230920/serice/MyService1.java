package com.example.spring20230920.serice;

import com.example.spring20230920.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class) // 클래스에 트랜잭션 어노테이션이 적용되면 클래스의 모든 메소드들이 적용됨
// service 는 거의 하나의 업무단위를 모아놓은 클래스이기 때문에 클래스에 대게 적용시킴
public class MyService1 {

    private final MyDao6 dao;
    //@Transactional(rollbackFor = Exception.class)
    public void tx1() {
        dao.update1();
        // 오류 발생시 @Transactional 어노테이션으로 인해 자동으로 ROLLBACK
        // 결과값 보면 둘다 10000원으로 그대로임
        // ROLLBACK 조건 : 기본적으로 runtimeException에서만 발생, checkedExecption에서는 발생안함.
        // 그럼 모든 Exception에서 ROLLBACK 되게 하고 싶다면 어노테이션 속성값으로 (rollbackFor = Exception.class) 하면된다
        //int c = 1 / 0; // runtimeException
        dao.update2();


    }

}
