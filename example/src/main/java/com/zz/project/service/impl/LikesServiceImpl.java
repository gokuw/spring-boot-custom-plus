package com.zz.project.service.impl;

import com.zz.project.entity.Likes;
import com.zz.project.mapper.LikesMapper;
import com.zz.project.service.ILikesService;
import com.zz.project.param.LikesPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.zz.common.base.BaseService;
import com.zz.common.pagination.PageInfo;
import com.zz.common.pagination.Paging;
/**
 *  服务实现类
 *
 * @author wjy
 * @since 2021-05-25
 */
@Service
public class LikesServiceImpl extends BaseService<LikesMapper, Likes> implements ILikesService {

    @Autowired
    private LikesMapper likesMapper;




    @Override
    public boolean saveLikes(Likes likes)   {
        return this.save(likes);
    }

    @Override
    public boolean updateLikes(Likes likes)   {
        return this.updateById(likes);
    }

    @Override
    public boolean deleteLikes(String sid)   {
             Likes  obj =this.getById(sid);
             if(null != obj){
                 obj.setScbj(1);
            }
        return this.saveOrUpdate(obj);
    }

    @Override
    public boolean delBatchLikes(List<String> sids)   {
        List<Likes> list = new ArrayList<>(16);
        for(String sid:sids){
         Likes obj = this.getById(sid);
            if(obj !=null){
                obj.setScbj(1);
                list.add(obj);
            }
        }
        return this.saveOrUpdateBatch(list);

    }

    @Override
    public Likes getLikesById(String sid)   {
        Likes obj = likesMapper.getLikesById(sid);
         return obj ;
    }

    @Override
    public Paging<Likes> getLikesPageList(LikesPageParam likesPageParam)   {
            Page<Likes> page = new PageInfo<>(likesPageParam, OrderItem.desc(getLambdaColumn(Likes::getGxsj)));
                IPage<Likes> iPage = likesMapper.getLikesPageList(page, likesPageParam);


            return new Paging<Likes>(iPage);
    }
    private void disposeObj(Likes obj) {
     }

}
