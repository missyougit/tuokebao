package xian.huiyuan.controller;

import common.response.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xian.huiyuan.model.Huiyuan;
import xian.huiyuan.model.HuiyuanResponse;
import xian.huiyuan.service.HuiyuanService;

@RestController
@RequestMapping("huiyuan")
public class HuiyuanController {

    @Autowired
    private HuiyuanService huiyuanService;

    @GetMapping("/{huiyuanid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanById(@PathVariable("huiyuanid")int huiyuanid){
        return huiyuanService.getHuiyuanById(huiyuanid);
    }

    @GetMapping("/by/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanByYuangongid(@PathVariable("yuangongid")int yuangongid,int pageNo,int pageSize){

        return huiyuanService.getHuiyuanByYuangongid(yuangongid,pageNo,pageSize);
    }

    @PostMapping("/addHuiyuan")
    public CommonResponse<HuiyuanResponse> addHuiyuan(@RequestBody Huiyuan huiyuan){

        return huiyuanService.addHuiyuan(huiyuan);
    }

    @GetMapping("/getTotal/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanTotalByYuangongid(@PathVariable("yuangongid")int yuangongid){

        return huiyuanService.getHuiyuanTotalByYuangongid(yuangongid);
    }


    @GetMapping("/search/{yuangongid}")
    public CommonResponse<HuiyuanResponse> getHuiyuanBySearchText(@PathVariable("yuangongid")int yuangongid,String searchText){

        return huiyuanService.getHuiyuanBySearchText(yuangongid,searchText);
    }

}
