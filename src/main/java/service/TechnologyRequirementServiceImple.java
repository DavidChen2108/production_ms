package service;

import bean.TechnologyRequirement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImple implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper mapper;

    @Override
    public int deleteByPrimaryKey(String technologyRequirementId) {
        int i = mapper.deleteByPrimaryKey(technologyRequirementId);
        return i;
    }

    @Override
    public int insert(TechnologyRequirement record) {
        int insert = mapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(TechnologyRequirement record) {
        return 0;
    }

    @Override
    public TechnologyRequirement selectByPrimaryKey(String technologyRequirementId) {
        TechnologyRequirement key = mapper.selectByPrimaryKey(technologyRequirementId);
        return key;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyRequirement record) {
        return 0;
    }

    @Override
    public List<TechnologyRequirement> selectAllRequirement() {
        List<TechnologyRequirement> list = mapper.selectAllRequirement();
        return list;
    }

    @Override
    public int updateByPrimaryKey(TechnologyRequirement record) {
        int i = mapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public List selectRequirementByPage(String page, String rows) {
      return null;
    }
    @Override
    public PageInfo<TechnologyRequirement> selectDocByPage1(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<TechnologyRequirement> docs = mapper.selectByPageAndSelections();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(docs);
        return pageInfo;
    }
    /*technologyName
            technologyName*/

}
