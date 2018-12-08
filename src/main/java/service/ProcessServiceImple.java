package service;

import bean.Process;
import bean.TechnologyRequirement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImple implements ProcessService{
    @Autowired
    ProcessMapper mapper;

    @Override
    public int deleteByPrimaryKey(String processId) {
        int i = mapper.deleteByPrimaryKey(processId);
        return i;
    }

    @Override
    public int insert(Process record) {
        int insert = mapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(Process record) {
        return 0;
    }

    @Override
    public Process selectByPrimaryKey(String processId) {
        Process process = mapper.selectByPrimaryKey(processId);
        return process;
    }

    @Override
    public List<Process> selectAllProcess() {
        List<Process> processes = mapper.selectAllProcess();
        return processes;
    }

    @Override
    public int updateByPrimaryKeySelective(Process record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Process record) {
        int i = mapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<Process> selectDocByPage1(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Process> processes = mapper.selectAllProcess();
        PageInfo<Process> pageInfo = new PageInfo<>(processes);
        return pageInfo;
    }

    @Override
    public List technologyPlanId(String value) {
        List<Process> processes = mapper.technologyPlanId(value);
        return processes;
    }
}
