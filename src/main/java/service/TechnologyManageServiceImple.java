package service;

import bean.TechnologyManage;
import mapper.TechnologyManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManageServiceImple implements TechnologyManageService {
    @Autowired
    TechnologyManageMapper manageMapper;


    @Override
    public List<TechnologyManage> getAllTechnology() {
        List<TechnologyManage> manages = manageMapper.selectAllTechnology();
        return manages;
    }

    @Override
    public int deleteByPrimaryKey(String technologyId) {
        int i = manageMapper.deleteByPrimaryKey(technologyId);
        return i;
    }

    @Override
    public int insert(TechnologyManage record) {
        int insert = manageMapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(TechnologyManage record) {
        return 0;
    }

    @Override
    public TechnologyManage selectByPrimaryKey(String technologyId) {
        TechnologyManage manage = manageMapper.selectByPrimaryKey(technologyId);
        return manage;
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyManage record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TechnologyManage record) {
        int i = manageMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public List<TechnologyManage> getTechnologyByPage(int page, int rows) {
                    int number = manageMapper.getTechnologyNumber();
                    if(number <rows||page==1){
                      return manageMapper.selectAllTechnology();
                    }

        int offset = (page-1) * rows;
        int limit = number - offset;
        List<TechnologyManage> manages = manageMapper.getTechnologyByPage(offset,limit);
        return manages;
    }

    @Override
    public List selectByName(String value) {
         List rows = manageMapper.selectByName(value);
         return rows;
    }
}
