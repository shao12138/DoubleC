package com.ysy.doublec.Mapper;

import com.ysy.doublec.Pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDao {
    @Select("select * from members where tell=#{tell}")
    Member findByMemberTell(String tell);

    @Insert("insert into members(address,age,content,idcard,name,password,sex,tell) " +
            "values(#{address},#{age},#{content},#{idcard},#{name},#{password},#{sex},#{tell})")
    void add(Member member);
}
