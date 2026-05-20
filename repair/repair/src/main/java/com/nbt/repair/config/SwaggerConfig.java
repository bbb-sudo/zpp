package com.nbt.repair.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("小型维修工单调度管理系统")
                        .version("1.0")
                        .description("SpringBoot3 + Vue3 前后端分离项目接口文档")
                        .contact(new Contact()
                                .name("team")
                                .url("www.repair.com")
                        )
                );
    }
}