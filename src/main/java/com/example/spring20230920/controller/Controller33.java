package com.example.spring20230920.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main33")
public class Controller33 {

    @GetMapping("sub1")
    public void method1() {

    }

    @PostMapping("sub2")
    public void method2(String name,
                        Integer age,
                        MultipartFile myfile) throws IOException {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        if (myfile != null) {


            // 전송받은 파일 이름 가져오기
            String fileName = myfile.getOriginalFilename();
            // 경로 및 파일명 설정
            String path = "C:\\Temp\\CodeStudy\\upload_" + fileName;
            System.out.println("fileName = " + fileName);
            // 파일을 받는거니깐 InputStream
            InputStream inputStream = myfile.getInputStream();
            // 파일을 받아서 저장(내보내기)해야하니깐 FileOutputStream
            FileOutputStream outputStream = new FileOutputStream(path);

            // Bufferd로 성능 향상
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            // Excepation 잡아주고
            try (bis; bos; inputStream; outputStream;) {
                // byte 크기 정하고
                byte[] data = new byte[1024];
                int len = 0;

                // 전송시키기
                while ((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }

                // 종료 후 남은 잔여 데이터 있을 수 있는거 flush()로 다 내보내기
                bos.flush();
            }
        }

    }

    @GetMapping("sub3")
    public void method3() {

    }

    @PostMapping("sub4")
    public void method4(MultipartFile upload) throws Exception {

        String fileName = upload.getOriginalFilename();
        String path = "C:\\Temp\\CodeStudy\\" + "231020_upload_" + fileName;

        InputStream is = upload.getInputStream();
        FileOutputStream os = new FileOutputStream(path);

        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(os);

        try (is; os; bis; bos;) {
            byte[] bytes = new byte[1024];

            int len = 0;

            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            bos.flush();
        }

    }

    @GetMapping("sub5")
    public void method5() {

    }

    @PostMapping("sub6")
    public void method6(MultipartFile[] files) throws IOException {
        System.out.println("files.length = " + files.length); // 파일이 없어도 1이 나옴
        System.out.println("업로드 파일 크기들");
        for (MultipartFile file : files) {

            // 파일의 크기로 파일이 있는지 없는지 확인
            if (file.getSize() > 0) {
                String path = "C:\\Temp\\CodeStudy\\";
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));

                try (bis; bos;) {
                    byte[] data = new byte[1024];
                    int len = 0;
                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);
                    }
                    bos.flush();
                }
            }
        }
    }

    @GetMapping("sub7")
    public void method7() {

    }

    @PostMapping("sub8")
    public void method8(MultipartFile[] files) throws IOException {
        String path = "C:\\Temp\\upload\\";

        File file1 = new File(path);

        if (!file1.exists()) {
            file1.mkdir();
        } else if (file1.exists()) {

            for (MultipartFile file : files) {
                if (file.getSize() > 0) {
                    BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));

                    try (bis; bos;) {

                        byte[] data = new byte[1024];

                        int len = 0;
                        while ((len = bis.read(data)) != -1) {
                            bos.write(data, 0, len);
                        }
                        bos.flush();
                    }
                }
            }
        }


    }

}
