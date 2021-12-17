package xian.huiyuan.model;

import lombok.Data;

import java.util.List;

@Data
public class HuiyuanResponse {

    private List<Huiyuan> huiyuanList;
    private Huiyuan huiyuan;
    private Integer total;
    private Integer pageCount;

}
