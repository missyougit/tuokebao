package quanju.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignCilentConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
