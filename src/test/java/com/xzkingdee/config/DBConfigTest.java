package com.xzkingdee.config;

import com.mongodb.BasicDBList;
import com.mongodb.CommandResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DBConfig.class)
public class DBConfigTest {

    @Autowired
    MongoClientFactoryBean mongo;

    @Autowired
    MongoOperations dao;

    @Test
    public void mongo() throws Exception {
        assertNotNull(mongo);
    }

    @Test
    public void mongoTemplate(){
//        assertNotNull(dao);
        CommandResult result =  dao.executeCommand("{distinct:'sys_user', key:'userName'}");

        BasicDBList list = (BasicDBList)result.get("values");
        for (int i = 0; i < list.size(); i ++) {
            System.out.println("============values: " + list.get(i));
        }

        assertTrue(result.size() > 0);
    }
}