package org.elac.service.impl;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.lang.util.ByteSource;
import org.elac.entity.UsersEntity;
import org.elac.service.IUsersBusService;
import org.elac.service.IUsersService;
import org.elac.utils.RandomUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-13 21:08
 */
@Slf4j
@Service
public class UsersBusServiceImpl implements IUsersBusService {

    @Resource
    private IUsersService usersService;

    public static String createSalt(String userName) {
        return ByteSource.Util.bytes(userName).toBase64();
    }

    public static String encryptPassword(String password, String salt) {
        return new Sha256Hash(password + salt).toHex();
    }

    @Override
    public UsersEntity saveUser(UsersEntity user) {
        String salt = createSalt(user.getUserName());
        String pwd = RandomUtil.genRandom(6).toString();
        user.setPassword(encryptPassword(pwd, salt));
        user.setSalt(salt);
        usersService.insertUser(user);
        user.setPassword(pwd);
        return user;
    }
}