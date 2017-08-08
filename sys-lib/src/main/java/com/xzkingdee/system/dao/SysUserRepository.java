package com.xzkingdee.system.dao;

import com.xzkingdee.system.entity.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface SysUserRepository extends MongoRepository<SysUser, String> {
    List<SysUser> findByUserName(String userName);

    List<SysUser> findByUserCodeLike(String userCode);

    List<SysUser> findByUserNameAndUserCode(String userName, String userCode);

    List<SysUser> getByUserCode(String userCode);
}
