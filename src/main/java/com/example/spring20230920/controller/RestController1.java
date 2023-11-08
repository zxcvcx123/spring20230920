package com.example.spring20230920.controller;

import com.example.spring20230920.dao.RestDao1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/main1")
public class RestController1 {

    private final RestDao1 dao;

    // http://localhost:8080/api/main1/sub1
    @GetMapping("sub1")
    public String method1() {
        return "customer name!!";
    }

    // http://localhost:8080/api/main1/sub2
    //get 요청시
    //5번 고객의 customerName 응답
    @GetMapping("sub2")
    public List<Map<String, Object>> method2() {


        return dao.getCustomer();

    }


    @GetMapping("sub5")
    public ResponseEntity<String> getEmp(@RequestParam(value = "id", required = false) String id) {
        System.out.println("id: " + id);

        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dao.getEmp(id));
    }

    @GetMapping("sub6")
    public List<String> getEmpId() {

        return dao.getEmpId();
    }
}
