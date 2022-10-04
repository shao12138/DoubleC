package com.ysy.doublec.Mapper;

import com.ysy.doublec.Pojo.Cell;
import com.ysy.doublec.Pojo.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface CellDao {
    @Select("select * from cells where name=#{name}")
    Member findByCellName(String name);

    @Insert("insert into cells(name,kind,num,price,capacity,valtage,times,targetName) " +
            "values(#{name},#{kind},#{num},#{price},#{capacity},#{valtage},#{times},#{targetName})")
    void addCell(Cell cell);
//
//    @Select("select count(1) from members")
//    String getMemberCount();
//
//    @Select("select * from members limit ${start},10")
//    ArrayList<Member> listMembers(@Param(value = "start") String start);

    @Select("select count(1) from cells")
    String getCellCount();

//    @Update("update members set address=#{address},age=#{age},content=#{content},idcard=#{idcard},name=#{name}," +
//            "trust=#{trust},password=#{password},sex=#{sex} where tell=#{tell}")
//    void editMember(Member member);
//
//    void delMember(@Param("deleteIds") String[] deleteIds);
//
//    @Select("select * from members where tell=#{tell}")
//    Member listMemberByTell(String tell);
}
