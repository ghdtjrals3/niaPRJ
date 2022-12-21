package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalDTO {
    //시도
    private String location;
    //시도
    private String detailLocation;
    //종별
    private String type;
    //기관명
    private String name;
    //전화번호
    private String phoneNumber;
    //주소
}
