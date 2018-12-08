package service;

import bean.TechnologyPlan;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TechnologyPlanService {
    List<TechnologyPlan> getAllTechnologyPlan();
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    PageInfo<TechnologyPlan> selectDocByPage1(int currentPage, int pageSize);

    List selectByTechnologyName(String value);

    /*TechnologyPlan selectByTechnologyName(String value);*/
}
