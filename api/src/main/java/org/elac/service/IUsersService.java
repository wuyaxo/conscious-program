package org.elac.service;

import org.elac.entity.UsersEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author David
 * @since 2024-04-13 21:24:04
 */
public interface IUsersService extends IService<UsersEntity> {

    int insertUser(UsersEntity user);

}
