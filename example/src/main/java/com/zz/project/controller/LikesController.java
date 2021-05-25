package com.zz.project.controller;

import com.zz.project.entity.Likes;
import com.zz.project.service.ILikesService;
import lombok.extern.slf4j.Slf4j;
import com.zz.project.param.LikesPageParam;


import com.zz.common.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.common.model.PageRequest;

/**
 *  控制器
 *
 * @author wjy
 * @since 2021-05-25
 */
@Slf4j
@RestController
@RequestMapping("/likes")
@Api(value = "API", tags = {""})
public class LikesController {


    @Autowired
    private ILikesService likesService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @Log(modelName = "", action = Log.ADD,description="添加")
    @ApiOperation(value = "添加")
    public Boolean addLikes(Likes likes)   {
        return  likesService.saveOrUpdate(likes);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
   @Log(modelName = "修改", action = Log.UPDATE,description="修改")
    @ApiOperation(value = "修改")
    public Boolean updateLikes( Likes likes)   {
        return likesService.updateLikes(likes);
    }

    /**
     * 删除
     */
    @PostMapping("delete")
   @Log(modelName = "删除", action =Log.DELETE,description="删除")
    @ApiOperation(value = "删除")
    public boolean  deleteLikes(String  sid) {
        return likesService.deleteLikes(sid);
    }


    /**
     * 批量删除
     */
    @PostMapping("delBatch")
    @Log(modelName = "批量删除", action =Log.DELETE,description="批量删除")
    @ApiOperation(value = "批量删除")
     public Boolean delBatchLikes(@RequestParam(value="sids") List<String> sids ){

        return  likesService.delBatchLikes(sids);
     }


    /**
     * 根据id 获取详情
     */
    @PostMapping("getById")
   @Log(modelName = "详情", action = Log.SELECT,description="根据id查询")
    @ApiOperation(value = "详情", response = Likes.class)
    public Likes getByIdLikes( String id)   {
        return      likesService.getLikesById(id);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
       @Log(modelName = "分页列表", action = Log.SELECT,description="分页查询")
    @ApiOperation(value = "分页列表", response = Likes.class)
    public Paging<Likes> getLikesPageList( LikesPageParam likesPageParam)   {
        return likesService.getLikesPageList(likesPageParam);
    }

}

