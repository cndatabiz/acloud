/**
 * 功能描述: 非Web组件配置
 *
 * @author tommy create on 2017-08-08-11:43
 */

package com.xzkingdee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DBConfig.class)
@ComponentScan(
        basePackages = {"com.xzkingdee"},
        excludeFilters = {@Filter(type= FilterType.CUSTOM,value= RootConfig.WebPackage.class)}
)
public class RootConfig {

    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage(){
            super(Pattern.compile("com\\.xzkingdee\\.\\s+\\.web"));
        }
    }
}
