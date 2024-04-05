package org.elac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-04 12:18
 */

@Data
@TableName("T_USERS")
public class UserEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("first_name")
    private String firstName;
    @TableField("last_name")
    private String lastName;
    @TableField("cell_number")
    private String cellNumber;
    @TableField("address1")
    private String address1;
    @TableField("address2")
    private String address2;
    @TableField("city")
    private String city;
    @TableField("zip_code")
    private Integer zipCode;
    @TableField("state")
    private Integer state;
    @TableField("delete_flag")
    private Boolean delete;
    @TableField("create_time")
    private LocalDateTime createTime;
    @TableField("update_time")
    private LocalDateTime updateTime;
}