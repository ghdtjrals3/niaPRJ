package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BogunsoDTO {
    //시군
    private String locationDetail;
    //도
    private String location;
    //보건소명
    private String name;
    //소재지
    private String addr;
    //연락처
    private String phoneNumber;
    //진료과목
    private String type;
    //진료시간
    private String time;
}
