package xian.huiyuan.service;

import common.response.model.CommonResponse;
import xian.huiyuan.model.Huiyuan;
import xian.huiyuan.model.HuiyuanResponse;

public interface HuiyuanService {

    CommonResponse<HuiyuanResponse> getHuiyuanById(int huiyuanid);

    CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(int yuangongid,int pageNo,int pageSize);

    CommonResponse<HuiyuanResponse> addHuiyuan(Huiyuan huiyuan);

    CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(int yuangongid);

    CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(int yuangongid, String searchText);
}
