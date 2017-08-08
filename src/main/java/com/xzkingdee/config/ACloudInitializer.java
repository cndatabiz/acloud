/**
 * 功能描述: 应用初始化类
 *
 * @author tommy create on 2017-08-08-10:23
 */

package com.xzkingdee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ACloudInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    private final Logger logger = LoggerFactory.getLogger(ACloudInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.addFilter("name", new CharacterEncodingFilter("UTF-8", true))
                .addMappingForUrlPatterns(null, false, "/*");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //  启用spring mvc 相关配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ACloudWebConfig.class};
    }

    //  配置全局地址映射
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
