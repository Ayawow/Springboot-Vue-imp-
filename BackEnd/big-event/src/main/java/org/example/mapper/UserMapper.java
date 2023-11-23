package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

@Mapper
public interface UserMapper {


    //添加
    @Insert("insert into user(username,password,create_time,update_time)" + "values(#{username},#{password},now(),now())")
     void add(String username, String password);

    //根据用户名查询
    @Select("select * from user where username = #{username}")
    User findByName(String username);

    //更新
    @Update("update user set nickname = #{nickname},email=#{email},update_time=#{updateTime} where id = #{id}")
    void update(User user);

    //更新头像
    @Update("update user set user_pic = #{avatarUrl},update_time=now() where id = #{id}")
    void updateAvatar(String avatarUrl,Integer id);

    //更新密码
    @Update("update user set password = #{md5String},update_time=now() where id = #{id}")
    void updatePwd(String md5String, Integer id);
}
