package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao4;
import com.example.spring20230920.dao.MyDto24;
import com.example.spring20230920.domain.*;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main30")
public class Controller30 {

    private final MyDao4 dao4;

    @GetMapping("sub1")
    public void mehtod1(Integer id) {
        String name = dao4.select1(id);
        System.out.println("name = " + name);
    }

    @GetMapping("sub2")
    public void method2(Double from, Double to) {
        List<String> names = dao4.select2(from, to);
        names.forEach(System.out::println);
    }

    @GetMapping("sub3")
    public void method3(LocalDate from, LocalDate to) {
        List<String> list = dao4.select3(from, to);
        list.forEach(System.out::println);
        System.out.println(list.size());
        // 날짜 기준으로 from ~ to 에 주문된 상품명 출력(정렬해서, 중복없이)

    }


    @GetMapping("sub4")
    public void method4(MyDto25 dto) {

        List<String> list = dao4.select4(dto);
        System.out.println(list.size());
    }

    // /main30/sub5?country1=germany&country2=france
    @GetMapping("sub5")
    public void method5(MyDto26 dto) {
        List<String> list = dao4.select5(dto);
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    // /main30/sub6?from=1996-09-01&to=1996-09-30
    @GetMapping("sub6")
    public void method6(MyDto27 dto1, MyDto28 dto2) {
        Integer num = dao4.select6(dto1, dto2);
        System.out.println("num = " + num);
    }

    // /main30/sub7?page=2&rows=10&keyword=a
    @GetMapping("sub7")
    public void method7(MyDto29 dto1, MyDto30 dto2) {
        /* SELECT customerName
         *  FORM customers
         *  WHERE customerName LIKE '%a%'
         *  LIMIT 10, 10
         * */
        Integer nowPage = dto1.getPage();
        Integer limitPage = dto1.getRows();
        dto1.setFrom((nowPage - 1) * limitPage);

        List<String> names = dao4.select7(dto1, dto2);

        names.forEach(System.out::println);
        System.out.println(names.size());

    }

    @GetMapping("sub8")
    public void method8(MyDto31 dto) {
        Integer num = dao4.insert1(dto);
        System.out.println("num = " + num);
    }

    @GetMapping("sub9")
    public void method9() {

    }

    @PostMapping("sub10")
    public void method10(MyDto32 emp) {
        int row = dao4.insert2(emp);
        System.out.println(row + "행이 입력됨");
    }

    @GetMapping("sub11")
    public void method11(Integer id) {
        int num = dao4.delete1(id);
        System.out.println("삭제된 항목: " + num);
    }

    @GetMapping("sub12")
    public void method12(Integer pid) {
        int num = dao4.delete2(pid);
        System.out.println("삭제된 항목: " + num);
    }

    // /main30/sub13?id=2
    @GetMapping("sub13")
    public void method13(Integer id, Model model){
        // 직원 조회
        MyDto33 emp = dao4.select8(id);

        model.addAttribute("emp", emp);
    }

    @PostMapping("sub14")
    public String method14(MyDto33 dto, RedirectAttributes rttr){
        // 직원 수정

        int rows = dao4.update1(dto);

        if(rows== 1){
            rttr.addFlashAttribute("msg","수정 완료");
        } else {
            System.out.println("업데이트 문제 발생");
        }

        rttr.addAttribute("id", dto.getId());
        return "redirect:/main30/sub13";
    }

    //GET /main30/sub15?id=?
    // 3번 고객 조회 -> view로 포워딩
    @GetMapping("sub15")
    public void method15(Integer id, Model model) {
        MyDto34 list = dao4.select9(id);

        model.addAttribute("list", list);

    }


    //POST /main30/sub16

    // 고객 정보 수정 -> /main30/sub15?id=3 로 redirect
    @PostMapping("sub16")
    public String method16(MyDto34 dto, RedirectAttributes rttr){
        int num = dao4.update2(dto);

        if(num == 1) {
            rttr.addFlashAttribute("msg","수정 완료되었습니다.");
        } else {
            rttr.addFlashAttribute("msg", "수정이 잘못됐습니다.");
        }
        rttr.addAttribute("id", dto.getId());
        return "redirect:/main30/sub15";
    }

}
