package org.elac.service.impl;

import javax.annotation.Resource;
import org.elac.entity.UsersEntity;
import org.elac.mapper.UsersMapper;
import org.elac.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author David
 * @since 2024-04-13 21:24:04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersEntity> implements IUsersService {

    @Resource
    UsersMapper usersMapper;
    @Override
    public int insertUser(UsersEntity user) {
        return usersMapper.insertUser(user);
    }
}
