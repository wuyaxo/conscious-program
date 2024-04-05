package org.elac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.elac.entity.UserEntity;
import org.elac.mapper.UserMapper;
import org.elac.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 12:35
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public UserEntity getUser(Integer id) {
//        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        return this.getById(id);
    }
}