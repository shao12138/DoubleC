package com.ysy.doublec.Mapper;

import com.ysy.doublec.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    @Select("select id,username,password from users where username=#{username}")
    User findByUsername(String username);
}
