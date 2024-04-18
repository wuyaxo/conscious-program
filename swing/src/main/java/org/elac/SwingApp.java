package org.elac;

import javax.swing.JFrame;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.elac.mapper")
public class SwingApp extends JFrame {

//    public SwingApp() {
////        RegisterForm registerForm = SpringUtil.getBean(RegisterForm.class);
//    }


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SwingApp.class);
        application.run(args);
    }
}