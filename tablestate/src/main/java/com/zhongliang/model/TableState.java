package com.zhongliang.model;

import lombok.Data;

@Data
public class TableState {

    private int id;
    private String tablename;
    private int state;
    private String updatetime;
    private int yuangongid;

}
