package cn.tjpu.hzc.application.dao;

import cn.tjpu.hzc.application.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Trey
 * @since 2020/12/8
 */

public interface UserMapper {

    @Select("SELECT * FROM `tb_user` WHERE `name`=#{username} AND `userpwd`=#{password}")
    User login(@Param("username") String username,@Param("password") String password);

    @Insert("INSERT INTO `tb_user` (`name`,`usertype`,`userpwd`,`userphone`,`status`)VALUES(#{user.name},#{user.usertype},#{user.userpwd},#{user.userphone},#{user.status})")
    void addUser(@Param("user") User user);

    @Update("UPDATE `tb_user` SET `name`=#{user.name},`usertype`=#{user.usertype},`userpwd`=#{user.userpwd},`userphone`=#{user.userphone},`status`=#{user.status} WHERE `id`=#{user.id}")
    void modify(@Param("user") User user);

    @Select("SELECT * FROM `tb_user`")
    ArrayList<User> selectAll();
}
