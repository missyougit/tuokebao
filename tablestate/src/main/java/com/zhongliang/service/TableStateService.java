package com.zhongliang.service;

import com.zhongliang.model.TableState;
import common.response.model.CommonResponse;

public interface TableStateService {

    CommonResponse<TableState> getYuangongById(int id);

}
