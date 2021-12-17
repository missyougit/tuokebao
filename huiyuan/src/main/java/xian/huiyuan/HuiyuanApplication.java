package xian.huiyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import quanju.feign.client.YuangongClient;

@SpringBootApplication
@MapperScan("xian.huiyuan.mapper")
@EnableFeignClients(clients = {YuangongClient.class})
@EnableEurekaClient
public class HuiyuanApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuiyuanApplication.class,args);
    }
}
