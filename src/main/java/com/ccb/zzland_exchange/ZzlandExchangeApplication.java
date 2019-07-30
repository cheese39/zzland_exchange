package com.ccb.zzland_exchange;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccb.zzland_exchange.mapper")
public class ZzlandExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzlandExchangeApplication.class, args);
    }

}
