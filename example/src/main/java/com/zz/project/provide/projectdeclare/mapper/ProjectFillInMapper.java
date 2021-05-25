package com.zz.project.provide.projectdeclare.mapper;

import com.zz.common.base.BaseMapper;
import com.zz.project.provide.projectdeclare.entity.ProjectFillIn;
import com.zz.project.provide.projectdeclare.param.ProjectFillInPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 申报填报申请信息表 Mapper 接口
 *
 * @author czg
 * @since 2021-05-25
 */
@Repository
public interface ProjectFillInMapper extends BaseMapper<ProjectFillIn> {

    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    ProjectFillIn getProjectFillInById(String sid);

    /**
     * 获取分页对象
     *
     * @param page
     * @param
     * @return
     */
    IPage<ProjectFillIn> getProjectFillInPageList(@Param("page") Page page, @Param("param") ProjectFillInPageParam projectFillInPageParam);

}
