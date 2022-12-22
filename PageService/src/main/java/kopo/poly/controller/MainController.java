package kopo.poly.controller;

import kopo.poly.dto.*;
import kopo.poly.service.IMainService;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final IMainService mainService;

    /*Thymeleaf boardWrite*/
    @GetMapping(value = "/covid/index")
    public String indexPage(Model model) throws ParserConfigurationException, IOException, SAXException {
        log.info(this.getClass().getName() + " 인덱스 페이지 시작!");
        List<CovidPaDTO> covidPaList = mainService.getCovidPa();
        String todayCovidNum = mainService.getCovidNum();
        model.addAttribute("covidPaList", covidPaList);
        model.addAttribute("todayCovidNum", todayCovidNum);
        log.info(this.getClass().getName() + " 인덱스 페이지 종료!");
        return "main/index";
    }

    @GetMapping(value = "/covid/list1")
    public String list1() throws Exception {
        log.info(this.getClass().getName() + " list1 Start !!");

        log.info(this.getClass().getName() + " list1 End !!");
        return "main/list1";
    }
    @GetMapping(value = "/covid/list2")
    public String list2() throws Exception {
        log.info(this.getClass().getName() + " list2 Start !!");

        log.info(this.getClass().getName() + " list2 End !!");
        return "main/list2";
    }
    @ResponseBody
    @PostMapping(value = "/covid/getNo1Ift")
    public List<No1IftDTO> getNo1Ift(@RequestBody Map<String, String> param) throws Exception {
        log.info(this.getClass().getName() + ".getNo1Ift Start!!");
        String year = CmmUtil.nvl(String.valueOf(param.get("year")));
        String dsvd = CmmUtil.nvl(String.valueOf(param.get("dsvd")));
        log.info("year : " + year);
        log.info("dsvd : " + dsvd);

        List<No1IftDTO> no1IftList = mainService.getNo1Ift(year, dsvd);
        log.info("List size : " + no1IftList.size());
        log.info(this.getClass().getName() + ".getNo1Ift End!!");
        return no1IftList;

    }

    @ResponseBody
    @PostMapping(value = "/covid/getNo4Ift")
    public List<No4IftDTO> getNo4Ift(@RequestBody Map<String, String> param) throws Exception {
        log.info(this.getClass().getName() + ".getNo4Ift Start!!");
        String year = CmmUtil.nvl(String.valueOf(param.get("year")));
        String dsvd = CmmUtil.nvl(String.valueOf(param.get("dsvd")));
        log.info("year : " + year);
        log.info("dsvd : " + dsvd);

        List<No4IftDTO> no4IftList = mainService.getNo4Ift(year, dsvd);
        log.info("List size : " + no4IftList.size());
        log.info(this.getClass().getName() + ".getNo4Ift End!!");
        return no4IftList;
    }

    @GetMapping(value = "/covid/hospital")
    public String hospital(Model model) throws Exception {
        log.info(this.getClass().getName() + " hospital 페이지 시작!");
        List<HospitalDTO> hospitalList = mainService.getHospital();
        log.info("hospitalList size : " + hospitalList.size());
        model.addAttribute("hospitalList", hospitalList);
        log.info(this.getClass().getName() + " hospital 페이지 종료!");
        return "main/hospital";
    }


    @GetMapping(value = "/covid/publichospital")
    public String publichospital(Model model) throws Exception{
        log.info(this.getClass().getName() + " publichospital 페이지 시작!");
        List<BogunsoDTO> bogunsoList = mainService.getBogunso();
        log.info("bogunsoList size : " + bogunsoList.size());
        model.addAttribute("bogunsoList", bogunsoList);
        log.info(this.getClass().getName() + " publichospital 페이지 종료!");
        return "main/publichospital";
    }


    @GetMapping(value = "/covid/RegForm")
    public String regForm() {
        log.info(this.getClass().getName() + " RegForm 페이지 시작!");

        log.info(this.getClass().getName() + " RegForm 페이지 종료!");
        return "main/RegForm";
    }
    @GetMapping(value = "/covid/prevention1")
    public String prevention1() {
        log.info(this.getClass().getName() + " RegForm 페이지 시작!");

        log.info(this.getClass().getName() + " RegForm 페이지 종료!");
        return "main/prevention1";
    }

    @GetMapping(value = "/covid/preventionQ")
    public String preventionQ() {
        log.info(this.getClass().getName() + " RegForm 페이지 시작!");

        log.info(this.getClass().getName() + " RegForm 페이지 종료!");
        return "main/preventionQ";
    }
}
