package service;

import bean.TechnologyRequirement;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TechnologyRequirementService {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);
    List<TechnologyRequirement> selectAllRequirement();

    int updateByPrimaryKey(TechnologyRequirement record);

    List selectRequirementByPage(String page, String rows);

    PageInfo<TechnologyRequirement> selectDocByPage1(int currentPage, int pageSize);
}
