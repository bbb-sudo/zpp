package com.nbt.repair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan("com.nbt.repair.mapper")
@SpringBootApplication
@ServletComponentScan
public class RepairApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairApplication.class, args);
    }

}
