package mapper;

import bean.TechnologyManage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TechnologyManageMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(TechnologyManage record);

    int insertSelective(TechnologyManage record);

    TechnologyManage selectByPrimaryKey(String technologyId);
    List<TechnologyManage> selectAllTechnology();

    int updateByPrimaryKeySelective(TechnologyManage record);

    int updateByPrimaryKey(TechnologyManage record);

    @Select("select count(*) from technology")
    int getTechnologyNumber();

    @Select("select * from technology offset `offset` and limit `limit`")
    List<TechnologyManage> getTechnologyByPage(@Param("offset") int offset, @Param("limit") int limit);
    /*@Select("select * from technology where technology_name = #{value}")*/
    List selectByName( String value);
}