package mapper;

import bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);
    List<TechnologyRequirement> selectAllRequirement();

    int updateByPrimaryKey(TechnologyRequirement record);

  /*  @Select("select * from technology_requirement")*/
    public List<TechnologyRequirement> selectByPageAndSelections();

    @Select("select * from technology_requirement where requirement =#{name}")
    List<TechnologyRequirement> selectRequirementByName(String requirement);

}