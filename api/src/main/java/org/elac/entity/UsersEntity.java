package org.elac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author David
 * @since 2024-04-07 22:56:23
 */
@Getter
@Setter
@TableName("T_USERS")
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private Integer id;

    @TableField("USER_ID")
    private Integer userId;

    @TableField("FIRST_NAME")
    private String firstName;

    @TableField("LAST_NAME")
    private String lastName;

    @TableField("CELL_NUMBER")
    private String cellNumber;

    @TableField("ADDRESS1")
    private String address1;

    @TableField("ADDRESS2")
    private String address2;

    @TableField("CITY")
    private String city;

    @TableField("ZIP_CODE")
    private Integer zipCode;

    @TableField("STATE")
    private Short state;

    @TableField("DELETE_FLAG")
    @TableLogic
    private Boolean deleteFlag;

    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;
}
