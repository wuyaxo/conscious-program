package org.elac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 09:49
 */

@SpringBootApplication
@MapperScan(basePackages = "org.elac.mapper")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApiApplication.class);
        application.run(args);

    }

}