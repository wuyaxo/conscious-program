package org.elac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.elac.entity.UsersEntity;

/**
 * <p>
 *  Mapper Interface
 * </p>
 *
 * @author David
 * @since 2024-04-07 22:56:23
 */
public interface UsersMapper extends BaseMapper<UsersEntity> {

    int insertUser(UsersEntity entity);
}
