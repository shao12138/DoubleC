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
    Cell findByCellName(String name);

    @Insert("insert into cells(name,kind,num,num_now,price,capacity,capacity_now,valtage,times,rent_time,targetName,date) " +
            "values(#{name},#{kind},#{num},#{num},#{price},#{capacity},#{capacity},#{valtage},#{times},#{times},#{targetName},#{date})")
    void addCell(Cell cell);

    @Select("select count(1) from cells where position=#{position}")
    String getCellCount(String position);

    @Select("select * from cells where position=#{position} limit ${start},10 ")
    ArrayList<Cell> listCells(@Param(value = "start") String start, @Param(value = "position") String position);

    @Select("select * from cells where id=#{id}")
    Cell getCell(String id);

    void cell_change(@Param("ids") String[] ids,@Param("position")String position);

    @Update("update cells set name=#{name},kind=#{kind},num=#{num},num_now=#{num_now},price=#{price}," +
            "capacity=#{capacity},capacity_now=#{capacity_now},valtage=#{valtage},times=#{times},rent_time=#{rent_time}," +
            "targetName=#{targetName},date=#{date} where id=#{id}")
    void editCell(Cell cell);

    @Delete("delete from cells where id=#{id}")
    void delCell(@Param("id") String id);

}
