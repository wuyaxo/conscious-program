package org.elac.service;

import org.elac.entity.UsersEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  Service
 * </p>
 *
 * @author David
 * @since 2024-04-07 22:56:23
 */
public interface IUsersService extends IService<UsersEntity> {

    UsersEntity getUsersByUserId(Integer userId);

}
