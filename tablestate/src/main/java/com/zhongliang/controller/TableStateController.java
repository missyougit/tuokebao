package com.zhongliang.controller;

import com.zhongliang.model.TableState;
import com.zhongliang.service.TableStateService;
import common.response.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yuangong")
public class TableStateController {


    @Autowired
    private TableStateService tableStateService;

    @GetMapping("/{id}")
    public CommonResponse<TableState> getYuangongById(@PathVariable("id")int id){
        return tableStateService.getYuangongById(id);
    }



}
