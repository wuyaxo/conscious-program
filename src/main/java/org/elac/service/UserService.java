package org.elac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import org.elac.domain.user.UserEntity;

public interface UserService extends IService<UserEntity> {

    public UserEntity getUser(Integer id);

}
