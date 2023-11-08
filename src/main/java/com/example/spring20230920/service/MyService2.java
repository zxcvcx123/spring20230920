package com.example.spring20230920.service;

import com.example.spring20230920.dao.MyDao9;
import com.example.spring20230920.domain.MyDto33;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService2 {

    private final MyDao9 dao;

    public boolean validata(MyDto33 dto) {
        if (dto.getBirthDate() == null) {
            return false;
        }

        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            return false;
        }

        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            return false;
        }

        if (dto.getNotes() == null || dto.getNotes().isBlank()) {
            return false;
        }

        return true;
    }

    public int add(MyDto33 dto) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return dao.insertEmployee(dto);
    }
}
