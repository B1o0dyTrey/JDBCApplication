package cn.tjpu.hzc.application.dao;

import cn.tjpu.hzc.application.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @author Trey
 * @since 2020/12/8
 */
public interface ProductMapper {

    @Select("SELECT * FROM `tb_product`")
    ArrayList<Product> getAll();

    @Insert("INSERT INTO `tb_product` (`productname`,`mid`,`producecount`,`productprice`,`status`)VALUES(#{product.productname},#{product.mid},#{product.producecount},#{product.productprice},#{product.status})")
    void addProduct(@Param("product") Product product);

    @Delete("DELETE FROM `tb_product` WHERE `id` = #{id}")
    void delete(@Param("id") int id);

    @Update("UPDATE `tb_product` SET `status`=#{status} WHERE `id`=#{id}")
    void logicallyUpdate(@Param("id") int id, @Param("status") int status);

    @Select("SELECT * FROM `tb_product` WHERE `productname` LIKE '%${value}%'")
    ArrayList<Product> select(@Param("value") String value);

    @Select("SELECT `productname`,`productprice` FROM `tb_product` WHERE `id` = #{id}")
    Product getNameById(@Param("id") int id);

    @Update("UPDATE `tb_product` SET `producecount`=`producecount`-${count} WHERE `id`=#{id}")
    void purchase(@Param("count") double count,@Param("id") int id);

    @Select("SELECT `mauname` FROM `tb_mau` WHERE `phone` = #{mid}")
    String getMauByMid(@Param("mid") String mid);

    @Select("SELECT `mid` FROM `tb_product` WHERE `id`=#{id}")
    String getMidById(@Param("id") int id);
}
