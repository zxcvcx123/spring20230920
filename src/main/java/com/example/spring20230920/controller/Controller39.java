package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao8;
import com.example.spring20230920.domain.MyDto33;
import com.example.spring20230920.domain.MyDto45;
import com.example.spring20230920.service.MyService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main39")
public class Controller39 {

    private final MyDao8 dao;

    private final MyService2 service;

    @GetMapping("sub0")
    public String method0() {
        return "view1";
    }

    @GetMapping("sub1")
    @ResponseBody // ResponseEntity 타입이 있으면 @ResponseBody는 딱히 안써도 된다. spring이 알아서 해줌
    public ResponseEntity method1() {
        // ResponseEntity
        // : 응답코드, 응답본문 작성 가능한 객체

        return ResponseEntity.status(300).build();
    }

    @GetMapping("sub2")
    public ResponseEntity method2() {
        return ResponseEntity.status(400).build();
    }

    @GetMapping("sub3")
    public ResponseEntity method3() {

        return ResponseEntity.status(500).build();
    }

    @GetMapping("sub4")
    public ResponseEntity<MyDto45> method4(Integer id) {
        MyDto45 data = dao.selectProductId(id);

        if (data == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(data);
        }

        //return ResponseEntity.status(200).body(data);
        //return ResponseEntity.ok().body(data);
    }

    @GetMapping("sub5")
    public ResponseEntity method5() {
        if (Math.random() > 0.5) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("sub6")
    public ResponseEntity<?> method6(@RequestBody MyDto33 dto) {
        if (service.validata(dto)) {
            int rows = service.add(dto);
            if(rows== 1){
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("sub7")
    public ResponseEntity<?> method7(){
        HttpHeaders headers = new HttpHeaders();

        headers.set("location", "seoul-Korea");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
