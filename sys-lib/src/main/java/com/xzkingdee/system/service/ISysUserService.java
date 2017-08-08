/**
 * 功能描述:
 *
 * @author tommy create on 2017-08-08-15:18
 */

package com.xzkingdee.system.service;

import com.xzkingdee.system.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface ISysUserService {
    List<SysUser> findByUserName(String userName);

    List<SysUser> findByUserCodeLike(String userCode);

    List<SysUser> findByUserNameAndUserCode(String userName, String userCode);

    List<SysUser> getByUserCode(String userCode);

}
