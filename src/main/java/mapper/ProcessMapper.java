package mapper;

import bean.Process;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    List<Process> selectAllProcess();

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    @Select("select * from process where technology_plan_id = #{name}")
    List<Process> selectByPlanId(String name);

    /*@Select("select * from process where technology_plan_id = #{name}")
    List<Process> technologyPlanId(String value);*/

     List<Process> technologyPlanId(String value);
}