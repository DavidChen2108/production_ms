package service;


import bean.TechnologyPlan;
import bean.TechnologyRequirement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImple implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper mapper;

    @Override
    public List<TechnologyPlan> getAllTechnologyPlan() {
        List<TechnologyPlan> plans = mapper.getAllTechnologyPlan();
        return plans;
    }

    @Override
    public int deleteByPrimaryKey(String technologyPlanId) {
        int i = mapper.deleteByPrimaryKey(technologyPlanId);
        return i;
    }

    @Override
    public int insert(TechnologyPlan record) {
        int insert = mapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(TechnologyPlan record) {
        return 0;
    }

    @Override
    public TechnologyPlan selectByPrimaryKey(String technologyPlanId) {
        TechnologyPlan technologyPlan = mapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyPlan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TechnologyPlan record) {
        int i = mapper.updateByPrimaryKey(record);
        return i;
    }
        @Override
        public PageInfo<TechnologyPlan> selectDocByPage1(int currentPage, int pageSize) {
            PageHelper.startPage(currentPage, pageSize);
            List<TechnologyPlan> docs = mapper.getAllTechnologyPlan();
            PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(docs);
            return pageInfo;
        }

    @Override
    public List selectByTechnologyName(String value) {
        List list = mapper.selectByTechnologyName(value);
        return list;
    }
        /*for(TechnologyRequirement requirement:docs){
            System.out.println(requirement);
        }*/

}
