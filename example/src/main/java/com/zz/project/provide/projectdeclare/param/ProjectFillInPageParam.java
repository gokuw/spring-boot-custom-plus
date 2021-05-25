package com.zz.project.provide.projectdeclare.param;


import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 申报填报申请信息表 分页参数对象
 * </pre>
 *
 * @author czg
 * @date 2021-05-25
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "申报填报申请信息表分页参数")
public class ProjectFillInPageParam extends BasePageOrderParam {
private static final long serialVersionUID = 1L;

            @ApiModelProperty("项目名称")
            private String projectName;
            @ApiModelProperty("推荐单位")
            private String recommendDepartment;
            @ApiModelProperty("承担单位（申请单位）")
            private String applyForDepartment;
            @ApiModelProperty("社会统一信用代码")
            private String socialUnifiedCreditCode;
            @ApiModelProperty("法定代表人")
            private String declareContentAttachment;
            @ApiModelProperty("项目负责人")
            private String projectLeader;
            @ApiModelProperty("负责人联系电话")
            private String projectLeaderPhone;
            @ApiModelProperty("申报表ID")
            private String declareId;
            @ApiModelProperty("项目附件")
            private String projectAttachment;
            @ApiModelProperty("申报时间")
            private Date declareTime;
            @ApiModelProperty("发布状态0 待审批1初审通过待复审2返回修改3 待上会 4上会中5上会结束6初审未通过7复审未通过8审核通过")
            private Integer declareStatus;
            @ApiModelProperty("发布时间")
            private Date releaseTime;
            @ApiModelProperty("是否需要上会0否1是")
            private Integer toMeeting;
            @ApiModelProperty("申请项目类型字典apply_project_type")
            private String projectTypeDicCodes;
    @ApiModelProperty("申请项目类型字典apply_project_type-已查询字典")
    @TableField(exist=false)
    private String projectTypeDicCodesString;
            @ApiModelProperty("执行时间")
            private Date executeTime;
            @ApiModelProperty("申请用户唯一id")
            private String uniqueId;
            @ApiModelProperty("初审意见")
            private String firstTrialOpinion;
            @ApiModelProperty("复审意见")
            private String secTrialOpinion;
            @ApiModelProperty("所属领域")
            private String projectTerritoryTypeDicCodes;
    @ApiModelProperty("所属领域-已查询字典")
    @TableField(exist=false)
    private String projectTerritoryTypeDicCodesString;
                private String processInstanceId;
    @ApiModelProperty("开始时间")
    private Date beginDate;

    @ApiModelProperty("结束时间")
    private Date endDate;

    @ApiModelProperty("查询时间段字段")
    private String  timeColume="djsj";
}
