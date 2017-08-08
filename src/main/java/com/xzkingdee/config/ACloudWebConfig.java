/**
 * 功能描述: 启用mvc基本配置
 *
 * @author tommy create on 2017-08-08-10:24
 */

package com.xzkingdee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.xzkingdee")
public class ACloudWebConfig extends WebMvcConfigurerAdapter{
    private final Logger logger = LoggerFactory.getLogger(ACloudWebConfig.class);

    //  配置jsp视图解析器
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/views");
        resolver.setSuffix(".jsp");

        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }

    //  配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
