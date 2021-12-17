package zhongliang.yuangong.service;

import common.response.model.CommonResponse;
import zhongliang.yuangong.model.Yuangong;

public interface YuangongService {

    CommonResponse<Yuangong> getYuangongById(int id);

    CommonResponse<Yuangong> logon(Yuangong yuangong);

    CommonResponse<Yuangong> register(Yuangong yuangong);

}
