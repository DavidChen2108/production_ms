package mapper;

import bean.TechnologyPlan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);
    List<TechnologyPlan> getAllTechnologyPlan();


    List selectByTechnologyName(String value);

    /*List<TechnologyPlan> getTechnologyPlanBy();*/

}