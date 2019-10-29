package com.xb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author zch
 * @ MapperScan(basePackages = {"com.xb.mapper"})
 */
@SpringBootApplication
public class Run {
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}
