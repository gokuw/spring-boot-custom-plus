package com.zz.project.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zz.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 
 *
 * @author wjy
 * @since 2021-07-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("zz_likes")
@ApiModel(value = "Likes实体对象")
public class Likes extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("点赞用户id")
    private String yhid;

    @ApiModelProperty("点赞资源id")
    private Integer zyid;

    @ApiModelProperty("模块")
    private String module;

}
