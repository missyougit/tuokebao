package xian.huiyuan.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xian.huiyuan.model.Huiyuan;

import java.util.List;

@Mapper
public interface HuiyuanMapper {

    @Select("select * from huiyuan where id=#{id}")
    Huiyuan getHuiyuanById(int id);

    @Select("select * from huiyuan where yuangongid=#{yuangongid} ORDER BY entrytime DESC limit #{offset} , #{pageSize}")
    List<Huiyuan> getHuiyuanByYuangongid(int yuangongid,int offset,int pageSize);

    @Insert("insert into huiyuan values (#{id},#{name},#{gender},#{age},#{birthday},#{phone},#{yuangongid},#{entrytime},#{remarks})" +
            " ON DUPLICATE KEY UPDATE " +
            "name=#{name},gender=#{gender},age=#{age},birthday=#{birthday},phone=#{phone}," +
            "yuangongid=#{yuangongid},entrytime=#{entrytime},remarks=#{remarks}")
    int addHuiyuan(Huiyuan huiyuan);

    //获取某员工的会员总数
    @Select("select COUNT(id) from huiyuan where yuangongid=#{yuangongid}")
    int getHuiyuanTotalByYuangongid(int yuangongid);

    @Select("select * from huiyuan where yuangongid=#{yuangongid} and (name like '%${searchText}%' or phone like '%${searchText}%')")
    List<Huiyuan> getHuiyuanBySearchText(@Param("yuangongid") int yuangongid,@Param("searchText") String searchText);


}
