package kopo.poly.service.impl;

import kopo.poly.dto.BogunsoDTO;
import kopo.poly.dto.HospitalDTO;
import kopo.poly.dto.No1IftDTO;
import kopo.poly.dto.No4IftDTO;
import kopo.poly.service.IMainService;
import kopo.poly.util.PasingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("MainService")
public class MainService implements IMainService {


    @Override
    public List<No1IftDTO> getNo1Ift(String year, String dsvd) throws ParserConfigurationException, IOException, SAXException {
        log.info("start!!");
        String url = "getCallStat01Api";
        String []keyArr = {"numOfRows","pageNo", "year", "dvsd"};
        String []valueArr = {"500", "1", year, URLEncoder.encode(dsvd, "UTF-8")};

        List<No1IftDTO> no1IftList = new ArrayList<>();

        Document document = PasingUtil.xmlPasing(url, keyArr, valueArr);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("item");

        for(int temp=0; temp<nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            No1IftDTO no1IftDTO = new No1IftDTO();

            no1IftDTO.setYear(PasingUtil.getTagValue("year", eElement));
            no1IftDTO.setDvsd(PasingUtil.getTagValue("dvsd", eElement));
            no1IftDTO.setChlrOcnm(PasingUtil.getTagValue("chlrOcnm", eElement));
            no1IftDTO.setChlrOcrt(PasingUtil.getTagValue("chlrOcrt", eElement));
            no1IftDTO.setChlrNmdth(PasingUtil.getTagValue("chlrNmdth", eElement));
            no1IftDTO.setTypdOcnm(PasingUtil.getTagValue("typdOcnm", eElement));
            no1IftDTO.setTypdOcrt(PasingUtil.getTagValue("typdOcrt", eElement));
            no1IftDTO.setTypdNmdth(PasingUtil.getTagValue("typdNmdth", eElement));
            no1IftDTO.setPrfvrOcnm(PasingUtil.getTagValue("prfvrOcnm", eElement));
            no1IftDTO.setPrfvrOcrt(PasingUtil.getTagValue("prfvrOcrt", eElement));
            no1IftDTO.setPrfvrNmdth(PasingUtil.getTagValue("prfvrNmdth", eElement));
            no1IftDTO.setBctdsOcnm(PasingUtil.getTagValue("bctdsOcnm", eElement));
            no1IftDTO.setBctdsOcrt(PasingUtil.getTagValue("bctdsOcrt", eElement));
            no1IftDTO.setBctdsNmdth(PasingUtil.getTagValue("bctdsNmdth", eElement));
            no1IftDTO.setEtclifOcnm(PasingUtil.getTagValue("etclifOcnm", eElement));
            no1IftDTO.setEtclifOcrt(PasingUtil.getTagValue("etclifOcrt", eElement));
            no1IftDTO.setEtclifNmdth(PasingUtil.getTagValue("etclifNmdth", eElement));
            no1IftDTO.setHptaOcnm(PasingUtil.getTagValue("hptaOcnm", eElement));
            no1IftDTO.setHptaOcrt(PasingUtil.getTagValue("hptaOcrt", eElement));
            no1IftDTO.setHptaNmdth(PasingUtil.getTagValue("hptaNmdth", eElement));

            no1IftList.add(no1IftDTO);
        }

        return no1IftList;
    }

    @Override
    public List<No4IftDTO> getNo4Ift(String year, String dsvd) throws ParserConfigurationException, IOException, SAXException {
        String url = "getCallStat04Api";
        String []keyArr = {"numOfRows","pageNo", "year", "dvsd"};
        String []valueArr = {"500", "1", year, URLEncoder.encode(dsvd, "UTF-8")};

        List<No4IftDTO> no4IftList = new ArrayList<>();

        Document document = PasingUtil.xmlPasing(url, keyArr, valueArr);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("item");

        for(int temp=0; temp<nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            No4IftDTO no4IftDTO = new No4IftDTO();

            no4IftDTO.setYear(PasingUtil.getTagValue("year", eElement));
            no4IftDTO.setDvsd(PasingUtil.getTagValue("dvsd", eElement));
            no4IftDTO.setPstOcnm(PasingUtil.getTagValue("pstOcnm", eElement));
            no4IftDTO.setPstOcrt(PasingUtil.getTagValue("pstOcrt", eElement));
            no4IftDTO.setPstNmdth(PasingUtil.getTagValue("pstNmdth", eElement));
            no4IftDTO.setYlfvOcnm(PasingUtil.getTagValue("ylfvOcnm", eElement));
            no4IftDTO.setYlfvOcrt(PasingUtil.getTagValue("ylfvOcrt", eElement));
            no4IftDTO.setYlfvNmdth(PasingUtil.getTagValue("ylfvNmdth", eElement));
            no4IftDTO.setDgfvrOcnm(PasingUtil.getTagValue("dgfvrOcnm", eElement));
            no4IftDTO.setDgfvrOcrt(PasingUtil.getTagValue("dgfvrOcrt", eElement));
            no4IftDTO.setDgfvrNmdth(PasingUtil.getTagValue("dgfvrNmdth", eElement));
            no4IftDTO.setVrhfvOcnm(PasingUtil.getTagValue("vrhfvOcnm", eElement));
            no4IftDTO.setVrhfvOcrt(PasingUtil.getTagValue("vrhfvOcrt", eElement));
            no4IftDTO.setVrhfvNmdth(PasingUtil.getTagValue("vrhfvNmdth", eElement));
            no4IftDTO.setPckOcnm(PasingUtil.getTagValue("pckOcnm", eElement));
            no4IftDTO.setPckOcrt(PasingUtil.getTagValue("pckOcrt", eElement));
            no4IftDTO.setPckNmdth(PasingUtil.getTagValue("pckNmdth", eElement));
            no4IftDTO.setBtntxOcnm(PasingUtil.getTagValue("btntxOcnm", eElement));
            no4IftDTO.setBtntxOcrt(PasingUtil.getTagValue("btntxOcrt", eElement));
            no4IftDTO.setBtntxNmdth(PasingUtil.getTagValue("btntxNmdth", eElement));
            no4IftDTO.setSrptsOcnm(PasingUtil.getTagValue("srptsOcnm", eElement));
            no4IftDTO.setSrptsOcrt(PasingUtil.getTagValue("srptsOcrt", eElement));
            no4IftDTO.setSrptsNmdth(PasingUtil.getTagValue("srptsNmdth", eElement));
            no4IftDTO.setAmifhOcnm(PasingUtil.getTagValue("amifhOcnm", eElement));
            no4IftDTO.setAmifhOcrt(PasingUtil.getTagValue("amifhOcrt", eElement));
            no4IftDTO.setAmifhNmdth(PasingUtil.getTagValue("amifhNmdth", eElement));
            no4IftDTO.setSwiflOcnm(PasingUtil.getTagValue("swiflOcnm", eElement));
            no4IftDTO.setSwiflOcrt(PasingUtil.getTagValue("swiflOcrt", eElement));
            no4IftDTO.setSwiflNmdth(PasingUtil.getTagValue("swiflNmdth", eElement));
            no4IftDTO.setTlrmOcnm(PasingUtil.getTagValue("tlrmOcnm", eElement));
            no4IftDTO.setTlrmOcrt(PasingUtil.getTagValue("tlrmOcrt", eElement));
            no4IftDTO.setTlrmNmdth(PasingUtil.getTagValue("tlrmNmdth", eElement));
            no4IftDTO.setQueOcnm(PasingUtil.getTagValue("queOcnm", eElement));
            no4IftDTO.setQueOcrt(PasingUtil.getTagValue("queOcrt", eElement));
            no4IftDTO.setQueNmdth(PasingUtil.getTagValue("queNmdth", eElement));
            no4IftDTO.setWsnfvOcnm(PasingUtil.getTagValue("wsnfvOcnm", eElement));
            no4IftDTO.setWsnfvOcrt(PasingUtil.getTagValue("wsnfvOcrt", eElement));
            no4IftDTO.setWsnfvNmdth(PasingUtil.getTagValue("wsnfvNmdth", eElement));
            no4IftDTO.setNwifOcnm(PasingUtil.getTagValue("nwifOcnm", eElement));
            no4IftDTO.setNwifOcrt(PasingUtil.getTagValue("nwifOcrt", eElement));
            no4IftDTO.setNwifNmdth(PasingUtil.getTagValue("nwifNmdth", eElement));
            no4IftDTO.setLydsOcnm(PasingUtil.getTagValue("lydsOcnm", eElement));
            no4IftDTO.setLydsOcrt(PasingUtil.getTagValue("lydsOcrt", eElement));
            no4IftDTO.setLydsNmdth(PasingUtil.getTagValue("lydsNmdth", eElement));
            no4IftDTO.setTbepOcnm(PasingUtil.getTagValue("tbepOcnm", eElement));
            no4IftDTO.setTbepOcrt(PasingUtil.getTagValue("tbepOcrt", eElement));
            no4IftDTO.setTbepNmdth(PasingUtil.getTagValue("tbepNmdth", eElement));
            no4IftDTO.setUbrOcnm(PasingUtil.getTagValue("ubrOcnm", eElement));
            no4IftDTO.setUbrOcrt(PasingUtil.getTagValue("ubrOcrt", eElement));
            no4IftDTO.setUbrNmdth(PasingUtil.getTagValue("ubrNmdth", eElement));
            no4IftDTO.setChfvrOcnm(PasingUtil.getTagValue("chfvrOcnm", eElement));
            no4IftDTO.setChfvrOcrt(PasingUtil.getTagValue("chfvrOcrt", eElement));
            no4IftDTO.setChfvrNmdth(PasingUtil.getTagValue("chfvrNmdth", eElement));
            no4IftDTO.setSfvtsOcnm(PasingUtil.getTagValue("sfvtsOcnm", eElement));
            no4IftDTO.setSfvtsOcrt(PasingUtil.getTagValue("sfvtsOcrt", eElement));
            no4IftDTO.setSfvtsNmdth(PasingUtil.getTagValue("sfvtsNmdth", eElement));
            no4IftDTO.setMdrsdOcnm(PasingUtil.getTagValue("mdrsdOcnm", eElement));
            no4IftDTO.setMdrsdOcrt(PasingUtil.getTagValue("mdrsdOcrt", eElement));
            no4IftDTO.setMdrsdNmdth(PasingUtil.getTagValue("mdrsdNmdth", eElement));
            no4IftDTO.setZkvfOcnm(PasingUtil.getTagValue("zkvfOcnm", eElement));
            no4IftDTO.setZkvfOcrt(PasingUtil.getTagValue("zkvfOcrt", eElement));
            no4IftDTO.setZkvfNmdth(PasingUtil.getTagValue("zkvfNmdth", eElement));

            no4IftList.add(no4IftDTO);
        }

        return no4IftList;
    }

    @Override
    public List<HospitalDTO> getHospital() throws IOException, ParserConfigurationException, SAXException {
        log.info(this.getClass().getName() + " getHospital Start !!");
        String url = "getpubReliefHospList";
        String []keyArr = {"numOfRows","pageNo"};
        String []valueArr = {"500", "1"};

        List<HospitalDTO> hospitalList = new ArrayList<>();

        Document document = PasingUtil.xmlPasing(url, keyArr, valueArr);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("item");

        for(int temp=0; temp<nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            HospitalDTO hospitalDTO = new HospitalDTO();

            hospitalDTO.setType(PasingUtil.getTagValue("spclAdmTyCd", eElement));
            hospitalDTO.setName(PasingUtil.getTagValue("yadmNm", eElement));
            hospitalDTO.setLocation(PasingUtil.getTagValue("sidoNm", eElement));
            hospitalDTO.setPhoneNumber(PasingUtil.getTagValue("telno", eElement));
            hospitalDTO.setDetailLocation(PasingUtil.getTagValue("sgguNm", eElement));

            hospitalList.add(hospitalDTO);
        }

        log.info(this.getClass().getName() + " getHospital End !!");
        return hospitalList;
    }

    @Override
    public List<BogunsoDTO> getBogunso() throws IOException {
        log.info(this.getClass().getName() + " getBogunso Start !!");

        File f = new File("src/main/resources/static/file/bogunso.csv");

        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<BogunsoDTO> bogunsoList = new ArrayList<>();

        String line = "";
        while((line = bufferedReader.readLine()) != null) {
            log.info(line);
            String [] splitLine = line.split(",");
            BogunsoDTO bogunsoDTO = new BogunsoDTO();
            bogunsoDTO.setType(splitLine[0]);
            bogunsoDTO.setName(splitLine[1]);
            bogunsoDTO.setLocation(splitLine[2]);
            bogunsoDTO.setPhoneNumber(splitLine[3]);
            bogunsoList.add(bogunsoDTO);
        }
        bufferedReader.close();

        log.info(this.getClass().getName() + " getBogunso End !!");
        return bogunsoList;
    }
}
