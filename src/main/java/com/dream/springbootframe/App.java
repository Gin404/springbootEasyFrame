package com.dream.springbootframe;

import com.dream.springbootframe.config.netty.NettyService;
import org.springframework.boot.CommandLineRunner;
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
public class App implements CommandLineRunner {
	
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    //实现CommandLineRunner 重写run方法 这里放了netty的启动
    @Override
    public void run(String... args) throws Exception {
        new NettyService();
    }
}
