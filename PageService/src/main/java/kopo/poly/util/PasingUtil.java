package kopo.poly.util;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Slf4j
public class PasingUtil {
    public static Document xmlPasing(String url, String[] keyArr, String[] valueArr) throws ParserConfigurationException, IOException, SAXException {
        StringBuilder finalUrl = new StringBuilder();
        String defaultUrl = "http://223.130.129.189:9191/";
        finalUrl.append(defaultUrl).append(url).append("/");

        if(keyArr.length != valueArr.length) {
            return null;
        }

        for(int i=0; i<keyArr.length; i++) {
            if(i == keyArr.length-1){
                finalUrl.append(keyArr[i]).append("=").append(valueArr[i]);
            }else {
                finalUrl.append(keyArr[i]).append("=").append(valueArr[i]).append("&");
            }
        }
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document document = dBuilder.parse(finalUrl.toString());

        return document;
    }

    public static String getTagValue(String tag, String childTag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        for(int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

            //result += nlList.item(i).getFirstChild().getTextContent() + " ";
            result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
        }

        return result;
    }

    // tag값의 정보를 가져오는 함수
    public static String getTagValue(String tag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        result = nlList.item(0).getTextContent();

        return result;
    }

    public static JSONObject jsonPasing(String url, String[] keyArr, String[] valueArr) throws ParserConfigurationException, IOException, SAXException {
        StringBuilder finalUrl = new StringBuilder();
        String defaultUrl = "http://223.130.129.189:9191/";
        String result = "";
        String line = "";
        finalUrl.append(defaultUrl).append(url).append("/");

        if(keyArr.length != valueArr.length) {
            return null;
        }

        for(int i=0; i<keyArr.length; i++) {
            if(i == keyArr.length-1){
                finalUrl.append(keyArr[i]).append("=").append(valueArr[i]);
            }else {
                finalUrl.append(keyArr[i]).append("=").append(valueArr[i]).append("&");
            }
        }
        JSONObject jsonObject = new JSONObject();
        try{
            URL getUrl = new URL(finalUrl.toString());
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(getUrl.openStream()));
            while ((line = bf.readLine()) != null) {
                result = result.concat(line);
                log.info("result : " + result);
            }
            log.info("finalUrl : " + finalUrl);
            log.info("result : " + result);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject)jsonParser.parse(result);
        }catch(Exception e){
            e.printStackTrace();
        }



        return jsonObject;
    }
}
