package cn.test.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.test.spring.dao.mapper")
public class ApplicationStarter {
    public static void main(String[] args) {
        ApplicationContext app =  SpringApplication.run(ApplicationStarter.class, args);
    }
}
