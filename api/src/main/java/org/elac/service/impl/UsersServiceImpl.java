package org.elac.service.impl;

import java.util.Random;
import org.elac.entity.UsersEntity;
import org.elac.mapper.UsersMapper;
import org.elac.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * service implication
 * </p>
 *
 * @author David
 * @since 2024-04-07 22:56:23
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersEntity> implements IUsersService {

    private Integer genRandom(int bit) {
        //parameter verification
        if (bit <= 0) {
            return 0;
        }
        String source = "1234567890";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        // first bit could be 123456789
        randomString.append(source.charAt(random.nextInt(9)));
        if (bit > 1) {
            for (int i = 0; i <= bit - 1; i++) {
                // other bit could be 1234567890
                randomString.append(source.charAt(random.nextInt(10)));
            }
        }
        return Integer.parseInt(String.valueOf(randomString));
    }

    @Override
    public UsersEntity getUsersByUserId(Integer userId) {
        UsersEntity user = this.lambdaQuery().eq(UsersEntity::getUserId, userId).one();
        return user;
    }
}
