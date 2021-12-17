package zhongliang.yuangong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("zhongliang.yuangong.mapper")
@EnableEurekaClient
public class YuangongApplication {
    public static void main(String[] args) {
        SpringApplication.run(YuangongApplication.class,args);
    }
}
