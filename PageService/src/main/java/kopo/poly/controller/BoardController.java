package kopo.poly.controller;

import kopo.poly.service.IBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final IBoardService boardService;

    /*Thymeleaf boardWrite*/
    @GetMapping(value = "/index")
    public String indexPage() {
        log.info(this.getClass().getName() + " 인덱스 페이지 시작!");
        log.info(this.getClass().getName() + " 인덱스 페이지 종료!");

        return "index";
    }


}
