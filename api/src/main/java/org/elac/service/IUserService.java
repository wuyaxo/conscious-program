package org.elac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.elac.entity.UserEntity;

public interface IUserService extends IService<UserEntity> {

    public UserEntity getUser(Integer id);

}
