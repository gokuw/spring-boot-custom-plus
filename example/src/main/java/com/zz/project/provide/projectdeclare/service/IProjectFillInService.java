package com.zz.project.provide.projectdeclare.service;

import com.zz.project.provide.projectdeclare.entity.ProjectFillIn;
import com.zz.project.provide.projectdeclare.param.ProjectFillInPageParam;
import java.util.List;
import com.zz.common.base.IBaseService;
import com.zz.common.pagination.Paging;


/**
 * 申报填报申请信息表 服务类
 *
 * @author czg
 * @since 2021-05-25
 */
public interface IProjectFillInService extends IBaseService<ProjectFillIn> {

    /**
     * 保存
     *
     * @param projectFillIn
     * @return
     */
    boolean saveProjectFillIn(ProjectFillIn projectFillIn)  ;

    /**
     * 修改
     *
     * @param projectFillIn
     * @return
     */
    boolean updateProjectFillIn(ProjectFillIn projectFillIn)  ;

    /**
     * 删除
     *
     * @param sid
     * @return
     */
        boolean  deleteProjectFillIn(String sid);

    /**
     * 批量删除
     *
     * @param sids
     * @return
     */
    boolean delBatchProjectFillIn(List<String>  sids);


    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    ProjectFillIn getProjectFillInById(String  sid)  ;
    /**
     * 获取分页对象
     *
     * @param  projectFillInPageParam
     * @return
     */
      Paging<ProjectFillIn> getProjectFillInPageList(ProjectFillInPageParam projectFillInPageParam)  ;

}
