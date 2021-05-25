package com.zz.project.mapper;

import com.zz.common.base.BaseMapper;
import com.zz.project.entity.Likes;
import com.zz.project.param.LikesPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 *  Mapper 接口
 *
 * @author wjy
 * @since 2021-05-25
 */
@Repository
public interface LikesMapper extends BaseMapper<Likes> {

    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    Likes getLikesById(String sid);

    /**
     * 获取分页对象
     *
     * @param page
     * @param
     * @return
     */
    IPage<Likes> getLikesPageList(@Param("page") Page page, @Param("param") LikesPageParam likesPageParam);

}
