package service;

import bean.Process;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProcessService {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    List<Process> selectAllProcess();

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    PageInfo<Process> selectDocByPage1(int currentPage, int pageSize);

    List technologyPlanId(String value);
}
