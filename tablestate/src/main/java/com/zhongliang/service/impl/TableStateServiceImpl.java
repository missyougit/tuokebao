package com.zhongliang.service.impl;

import com.zhongliang.mapper.TableStateMapper;
import com.zhongliang.model.TableState;
import com.zhongliang.service.TableStateService;
import common.response.model.CommonResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TableStateServiceImpl implements TableStateService {

    @Resource
    private TableStateMapper tableStateMapper;

    @Override
    public CommonResponse<TableState> getYuangongById(int id) {


        return new CommonResponse<>(200,"Success",null);

    }



}
