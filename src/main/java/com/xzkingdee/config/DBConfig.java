/**
 * 功能描述: 数据库相关配置
 *
 * @author tommy create on 2017-08-08-11:26
 */

package com.xzkingdee.config;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.regex.Pattern;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.xzkingdee"},
        includeFilters = {@Filter(type= FilterType.CUSTOM,value= DBConfig.WebPackage.class)}
)
@PropertySource("db.properties")
public class DBConfig {

    @Autowired
    Environment env;

    @Bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
        mongoClientFactoryBean.setHost(env.getProperty("db.host"));
        mongoClientFactoryBean.setPort(Integer.parseInt(env.getProperty("db.port")));

        MongoCredential credential = MongoCredential.createCredential(

                env.getProperty("db.username"),
                env.getProperty("db.dbName"),
                env.getProperty("db.password").toCharArray()

        );

        MongoCredential [] credentials = {credential};

        mongoClientFactoryBean.setCredentials(credentials);

        return mongoClientFactoryBean;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo){
        return new MongoTemplate(mongo,"cloud");
    }

    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage(){
            super(Pattern.compile("com\\.xzkingdee\\.\\s+\\.dao"));
        }
    }

}
