package com.dream.springbootframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 * 
 */
@SpringBootApplication
//开启缓存
@EnableCaching
public class App {
	
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
