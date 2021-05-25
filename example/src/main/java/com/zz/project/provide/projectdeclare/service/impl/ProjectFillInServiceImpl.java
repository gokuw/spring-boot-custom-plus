package com.zz.project.provide.projectdeclare.service.impl;

import com.zz.project.provide.projectdeclare.entity.ProjectFillIn;
import com.zz.project.provide.projectdeclare.mapper.ProjectFillInMapper;
import com.zz.project.provide.projectdeclare.service.IProjectFillInService;
import com.zz.project.provide.projectdeclare.param.ProjectFillInPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.zz.project.provide.system.service.IBasicsXtzdService;
import java.util.Iterator;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import com.zz.common.base.BaseService;
import com.zz.common.pagination.PageInfo;
import com.zz.common.pagination.Paging;
/**
 * 申报填报申请信息表 服务实现类
 *
 * @author czg
 * @since 2021-05-25
 */
@Service
public class ProjectFillInServiceImpl extends BaseService<ProjectFillInMapper, ProjectFillIn> implements IProjectFillInService {

    @Autowired
    private ProjectFillInMapper projectFillInMapper;
    @Resource
    private IBasicsXtzdService xtzdService;




    @Override
    public boolean saveProjectFillIn(ProjectFillIn projectFillIn)   {
        return this.save(projectFillIn);
    }

    @Override
    public boolean updateProjectFillIn(ProjectFillIn projectFillIn)   {
        return this.updateById(projectFillIn);
    }

    @Override
    public boolean deleteProjectFillIn(String sid)   {
             ProjectFillIn  obj =this.getById(sid);
             if(null != obj){
                 obj.setScbj(1);
            }
        return this.saveOrUpdate(obj);
    }

    @Override
    public boolean delBatchProjectFillIn(List<String> sids)   {
        List<ProjectFillIn> list = new ArrayList<>(16);
        for(String sid:sids){
         ProjectFillIn obj = this.getById(sid);
            if(obj !=null){
                obj.setScbj(1);
                list.add(obj);
            }
        }
        return this.saveOrUpdateBatch(list);

    }

    @Override
    public ProjectFillIn getProjectFillInById(String sid)   {
        ProjectFillIn obj = projectFillInMapper.getProjectFillInById(sid);
           disposeObj(obj);
         return obj ;
    }

    @Override
    public Paging<ProjectFillIn> getProjectFillInPageList(ProjectFillInPageParam projectFillInPageParam)   {
            Page<ProjectFillIn> page = new PageInfo<>(projectFillInPageParam, OrderItem.desc(getLambdaColumn(ProjectFillIn::getGxsj)));
                IPage<ProjectFillIn> iPage = projectFillInMapper.getProjectFillInPageList(page, projectFillInPageParam);


                    Iterator<ProjectFillIn> iterator = iPage.getRecords().iterator();
                    while (iterator.hasNext()){
                     ProjectFillIn info = iterator.next();
                    disposeObj(info);
                 }
            return new Paging<ProjectFillIn>(iPage);
    }
    private void disposeObj(ProjectFillIn obj) {
                obj.setProjectTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getProjectTypeDicCodes()));

                obj.setProjectTerritoryTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getProjectTerritoryTypeDicCodes()));

     }

}
