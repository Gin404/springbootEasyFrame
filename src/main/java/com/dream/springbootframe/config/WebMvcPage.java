package com.dream.springbootframe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 所有的@RequestMapping("")最后只返回一个页面的都可以写在这里
 * 继承WebMvcConfigurerAdapter 重写addViewControllers
 */
@Configuration
public class WebMvcPage extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //UserController
        registry.addViewController("").setViewName("listpage");

        //FckController
        registry.addViewController("/fck/page").setViewName("fck");


    }
}
