package service;

import bean.TechnologyManage;

import java.util.List;

public interface TechnologyManageService {
    List<TechnologyManage> getAllTechnology();
    int deleteByPrimaryKey(String technologyId);

    int insert(TechnologyManage record);

    int insertSelective(TechnologyManage record);

    TechnologyManage selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(TechnologyManage record);

    int updateByPrimaryKey(TechnologyManage record);

    List<TechnologyManage> getTechnologyByPage(int page, int rows);

    List selectByName(String value);
}
