package com.zhongliang.mapper;

import com.zhongliang.model.TableState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TableStateMapper {

    @Select("select * from yuangong where id=#{id}")
    TableState getYuangongById(int id);


}
