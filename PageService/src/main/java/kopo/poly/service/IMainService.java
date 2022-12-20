package kopo.poly.service;

import kopo.poly.dto.BogunsoDTO;
import kopo.poly.dto.HospitalDTO;
import kopo.poly.dto.No1IftDTO;
import kopo.poly.dto.No4IftDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMainService {
    List<No1IftDTO> getNo1Ift() throws ParserConfigurationException, IOException, SAXException;

    List<No4IftDTO> getNo4Ift() throws ParserConfigurationException, IOException, SAXException;

    List<HospitalDTO> getHospital() throws IOException;

    List<BogunsoDTO> getBogunso() throws IOException;
}
