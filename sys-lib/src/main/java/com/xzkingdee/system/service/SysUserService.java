/**
 * 功能描述:
 *
 * @author tommy create on 2017-08-08-15:18
 */

package com.xzkingdee.system.service;

import com.google.common.base.Strings;
import com.xzkingdee.system.dao.SysUserRepository;
import com.xzkingdee.system.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService implements ISysUserService {
    private final Logger logger = LoggerFactory.getLogger(SysUserService.class);
    
    @Autowired
    private SysUserRepository dao;

    @Override
    public List<SysUser> findByUserName(String userName) {
        if (Strings.isNullOrEmpty(userName))
            return null;

        return dao.findByUserName(userName);
    }

    @Override
    public List<SysUser> findByUserCodeLike(String userCode) {
        if (Strings.isNullOrEmpty(userCode))
            return null;

        return dao.findByUserCodeLike(userCode);
    }

    @Override
    public List<SysUser> findByUserNameAndUserCode(String userName, String userCode) {
        if(Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(userCode))
            return null;

        return dao.findByUserNameAndUserCode(userName,userCode);
    }

    @Override
    public List<SysUser> getByUserCode(String userCode) {
        if (Strings.isNullOrEmpty(userCode))
            return null;

        return dao.findByUserName(userCode);
    }
}
