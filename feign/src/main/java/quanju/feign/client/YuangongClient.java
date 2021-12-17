package quanju.feign.client;

import common.response.model.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import quanju.feign.config.FeignCilentConfiguration;
import quanju.feign.model.Yuangong;

@FeignClient(value = "zhongliang-yuangong", configuration = FeignCilentConfiguration.class)
public interface YuangongClient {

    @GetMapping("/yuangong/{id}")
    CommonResponse<Yuangong> getYuangongById(@PathVariable("id")int id);

}
