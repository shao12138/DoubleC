package com.ysy.doublec.Mapper;

import com.ysy.doublec.Pojo.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface MemberDao {
    @Select("select * from members where tell=#{tell}")
    Member findByMemberTell(String tell);

    @Insert("insert into members(address,age,content,idcard,name,password,sex,tell) " +
            "values(#{address},#{age},#{content},#{idcard},#{name},#{password},#{sex},#{tell})")
    void addMember(Member member);

    @Select("select count(1) from members")
    String getMemberCount();

    @Select("select * from members limit ${start},10")
    ArrayList<Member> listMembers(@Param(value = "start") String start);

    @Select("select * from members where id=#{id}")
    Member getMember(String id);

    @Update("update members set address=#{address},age=#{age},content=#{content},idcard=#{idcard},name=#{name}," +
            "trust=#{trust},password=#{password},sex=#{sex} where tell=#{tell}")
    void editMember(Member member);
}
