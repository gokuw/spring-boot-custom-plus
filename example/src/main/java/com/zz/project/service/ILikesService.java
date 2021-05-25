package com.zz.project.service;

import com.zz.project.entity.Likes;
import com.zz.project.param.LikesPageParam;
import java.util.List;
import com.zz.common.base.IBaseService;
import com.zz.common.pagination.Paging;


/**
 *  服务类
 *
 * @author wjy
 * @since 2021-05-25
 */
public interface ILikesService extends IBaseService<Likes> {

    /**
     * 保存
     *
     * @param likes
     * @return
     */
    boolean saveLikes(Likes likes)  ;

    /**
     * 修改
     *
     * @param likes
     * @return
     */
    boolean updateLikes(Likes likes)  ;

    /**
     * 删除
     *
     * @param sid
     * @return
     */
        boolean  deleteLikes(String sid);

    /**
     * 批量删除
     *
     * @param sids
     * @return
     */
    boolean delBatchLikes(List<String>  sids);


    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    Likes getLikesById(String  sid)  ;
    /**
     * 获取分页对象
     *
     * @param  likesPageParam
     * @return
     */
      Paging<Likes> getLikesPageList(LikesPageParam likesPageParam)  ;

}
