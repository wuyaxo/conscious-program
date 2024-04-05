package org.elac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2024-04-05 11:23:11
 */
@Getter
@Setter
@TableName("T_LOGGING_LOG")
public class LoggingLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private Integer id;

    @TableField("USER_ID")
    private Integer userId;

    @TableField("STATUS")
    private Short status;

    @TableField("COMMENT")
    private String comment;

    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("IP_ADDRESS")
    private String ipAddress;
}
