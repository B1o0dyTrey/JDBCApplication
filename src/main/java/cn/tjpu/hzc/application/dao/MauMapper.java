package cn.tjpu.hzc.application.dao;

import cn.tjpu.hzc.application.domain.Mau;
import cn.tjpu.hzc.application.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @author Trey
 * @since 2020/12/8
 */
public interface MauMapper {

    @Select("SELECT * FROM `tb_mau`")
    ArrayList<Mau> getAll();

    @Delete("DELETE FROM `tb_mau` WHERE `id`=#{id}")
    void delete(@Param("id") int id);

    @Insert("INSERT INTO `tb_mau` (`mauname`,`phone`,`address`,`postcode`)VALUES(#{mau.mauname},#{mau.phone},#{mau.address},#{mau.postcode})")
    void insert(@Param("mau") Mau mau);

    @Update("UPDATE `tb_mau` SET `mauname`=#{mau.mauname},`phone`=#{mau.phone},`address`=#{mau.address},`postcode`=#{postcode}")
    void update(@Param("mau") Mau mau);

    @Select("SELECT * FROM `tb_mau` WHERE `mauname` LIKE '%${value}%'")
    ArrayList<Mau> select(@Param("value") String value);

    @Select("SELECT `phone` FROM `tb_mau` WHERE `id`=#{id}")
    String getPhoneById(@Param("id") int id);

    @Select("SELECT * FROM `tb_product` WHERE `mid`=#{phone}")
    ArrayList<Product> getAllProducts(@Param("phone") String phone);
}
