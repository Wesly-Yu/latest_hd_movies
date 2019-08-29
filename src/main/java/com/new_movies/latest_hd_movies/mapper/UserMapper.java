package com.new_movies.latest_hd_movies.mapper;


import com.new_movies.latest_hd_movies.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modfied) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);


}
