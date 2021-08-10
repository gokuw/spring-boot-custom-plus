package com.zz.project.param;


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
import com.zz.common.pagination.BasePageOrderParam;


/**
 * <pre>
 *  分页参数对象
 * </pre>
 *
 * @author wjy
 * @date 2021-07-30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页参数")
public class LikesPageParam extends BasePageOrderParam {
private static final long serialVersionUID = 1L;

            @ApiModelProperty("点赞用户id")
            private String yhid;
            @ApiModelProperty("点赞资源id")
            private Integer zyid;
            @ApiModelProperty("模块")
            private String module;
    @ApiModelProperty("开始时间")
    private Date beginDate;

    @ApiModelProperty("结束时间")
    private Date endDate;

    @ApiModelProperty("查询时间段字段")
    private String  timeColume="djsj";
}
