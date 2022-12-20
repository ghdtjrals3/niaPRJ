package kopo.poly.controller;

import kopo.poly.dto.BogunsoDTO;
import kopo.poly.dto.HospitalDTO;
import kopo.poly.dto.No1IftDTO;
import kopo.poly.dto.No4IftDTO;
import kopo.poly.service.IMainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final IMainService mainService;

    /*Thymeleaf boardWrite*/
    @GetMapping(value = "/index")
    public String indexPage() throws ParserConfigurationException, IOException, SAXException {
        log.info(this.getClass().getName() + " 인덱스 페이지 시작!");

//        // 제1군 감염병 발생 수 및 사망자 수
//        List<No1IftDTO> no1IftList = mainService.getNo1Ift();
//        log.info(no1IftList.size() + "");
//        // 제4군 감염병 발생 수 및 사망자 수
//        List<No4IftDTO> no4IftList = mainService.getNo4Ift();
//        log.info(no4IftList.size() + "");
        // 의료기관
        List<HospitalDTO> hospitalList = mainService.getHospital();
        // 보건소
        List<BogunsoDTO> bogunsoList = mainService.getBogunso();





        log.info(this.getClass().getName() + " 인덱스 페이지 종료!");
        return "index";
    }


}
