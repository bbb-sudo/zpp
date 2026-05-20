package com.nbt.repair.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("user")
@Schema(description = "用户信息实体类")
public class User {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 登录账号
     */
    @Schema(description = "登录账号")
    private String username;

    /**
     * 登录密码
     */
    @Schema(description = "登录密码")
    private String password;

    /**
     * 真实姓名
     */
    @Schema(description = "真实姓名")
    private String realName;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;

    /**
     * 角色：ADMIN管理员 / ENGINEER工程师 / CUSTOMER客户
     */
    @Schema(description = "角色：ADMIN管理员 / ENGINEER工程师 / CUSTOMER客户")
    private String role;

    /**
     * 工程师等级：初级、高级
     */
    @Schema(description = "工程师等级：初级、高级")
    private String level;

    /**
     * 技能标签 JSON字符串 例如 ["空调","冰箱"]
     */
    @Schema(description = "技能标签 JSON字符串 例如 [\"空调\",\"冰箱\"]")
    private String skillTags;

    /**
     * 平均评分
     */
    @Schema(description = "平均评分")
    private Double avgScore;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}