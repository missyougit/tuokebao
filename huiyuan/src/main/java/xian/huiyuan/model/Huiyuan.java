package xian.huiyuan.model;

import lombok.Data;
import quanju.feign.model.Yuangong;

@Data
public class Huiyuan {

    private int id;
    private String name;
    private String gender;
    private int age;
    private String birthday;
    private String phone;
    private int yuangongid;
    private String entrytime;
    private Yuangong yuangong;
    private String remarks;

}
