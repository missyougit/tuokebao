package xian.huiyuan.service.impl;

import common.response.model.CommonResponse;
import common.response.utils.DateUtils;
import org.springframework.stereotype.Service;
import quanju.feign.client.YuangongClient;
import quanju.feign.model.Yuangong;
import xian.huiyuan.mapper.HuiyuanMapper;
import xian.huiyuan.model.Huiyuan;
import xian.huiyuan.model.HuiyuanResponse;
import xian.huiyuan.service.HuiyuanService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HuiyuanServiceImpl implements HuiyuanService {

    private static String DATE_FORMATTER = "yyyy-MM-dd HH:mm";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Resource
    private HuiyuanMapper huiyuanMapper;
    @Resource
    private YuangongClient yuangongClient;

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanById(int huiyuanid) {

        Huiyuan huiyuan = huiyuanMapper.getHuiyuanById(huiyuanid);
        if (huiyuan == null){
            return new CommonResponse<>(400,"无效的会员号",null);
        }
        int yuangongid = huiyuan.getYuangongid();
        CommonResponse<Yuangong> yuangong = yuangongClient.getYuangongById(yuangongid);
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        if (yuangong == null){
            huiyuanResponse.setHuiyuan(huiyuan);
            return new CommonResponse<>(206,"Warning",huiyuanResponse);
        }
        Yuangong result = yuangong.getResult();
        huiyuan.setYuangong(result);
        huiyuanResponse.setHuiyuan(huiyuan);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(int yuangongid,int pageNo,int pageSize) {

        int offset = (pageNo - 1) * pageSize;
        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanByYuangongid(yuangongid,offset,pageSize);
        if (huiyuanList == null){
            return new CommonResponse<>(400,"您还没有会员",null);
        }
        CommonResponse<Yuangong> yuangong = yuangongClient.getYuangongById(yuangongid);
        Yuangong result = yuangong.getResult();
        for (Huiyuan huiyuan : huiyuanList) {
            huiyuan.setYuangong(result);
        }
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);
        int huiyuanTotal = huiyuanMapper.getHuiyuanTotalByYuangongid(yuangongid);
        huiyuanResponse.setTotal(huiyuanTotal);
        Integer pageCount;

        if (huiyuanTotal % pageSize == 0){
            pageCount = huiyuanTotal / pageSize;
        }else {
            pageCount = (int)Math.ceil((double)huiyuanTotal / (double)pageSize);
        }

        huiyuanResponse.setPageCount(pageCount);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> addHuiyuan(Huiyuan huiyuan) {

        int age = DateUtils.getAge(huiyuan.getBirthday());
        huiyuan.setAge(age);
        LocalDateTime currentTime = LocalDateTime.now();
        String entrytime = currentTime.format(dateTimeFormatter);
        huiyuan.setEntrytime(entrytime);
        int i = huiyuanMapper.addHuiyuan(huiyuan);
        if (i < 1){
            return new CommonResponse<>(500,"添加失败",null);
        }
        return new CommonResponse<>(200,"Success",null);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(int yuangongid) {

        int huiyuanTotal = huiyuanMapper.getHuiyuanTotalByYuangongid(yuangongid);
        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setTotal(huiyuanTotal);
        return new CommonResponse<>(200,"Success",huiyuanResponse);

    }

    @Override
    public CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(int yuangongid, String searchText) {

        List<Huiyuan> huiyuanList = huiyuanMapper.getHuiyuanBySearchText(yuangongid,searchText);

        if (huiyuanList.isEmpty()){
            return new CommonResponse<>(400,"查无此人",null);
        }

        HuiyuanResponse huiyuanResponse = new HuiyuanResponse();
        huiyuanResponse.setHuiyuanList(huiyuanList);

        return new CommonResponse<>(200,"Success",huiyuanResponse);
    }


}
