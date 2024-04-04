package org.elac.controller.user;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.elac.common.Result;
import org.elac.domain.user.UserEntity;
import org.elac.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 10:51
 */

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/get-user/v1/{id}")
    public Result<UserEntity> display(@PathVariable("id") Integer id) {
        log.debug("UserController.display called userId:{}", id);
        return Result.consume(id, userService::getUser);
    }

}