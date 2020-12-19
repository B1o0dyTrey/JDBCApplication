package cn.tjpu.hzc.application.server;

import cn.tjpu.hzc.application.dao.MauMapper;
import cn.tjpu.hzc.application.config.MybatisConfig;
import cn.tjpu.hzc.application.domain.Mau;
import cn.tjpu.hzc.application.domain.Product;
import cn.tjpu.hzc.application.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class MauService {
    private final SqlSession sqlSession = MybatisConfig.sqlSession;
    private final MauMapper mapper = sqlSession.getMapper(MauMapper.class);
    private SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Scanner scanner = new Scanner(System.in);
    /**
     * 查询所有供应商
     */
    public void getAll() {
        List<Mau> maus = mapper.getAll();
        System.out.println("id\tmauname\tphone\taddress\tpostcode\tcreatetime");
        for (Mau mau : maus) {
            System.out.println(mau.getId()+"\t"+mau.getMauname()+"\t\t"+mau.getPhone()+"\t\t"+mau.getAddress()+"\t"+mau.getPostcode()+"\t\t"+simpleDate.format(mau.getCreatetime()));
        }
    }

    /**
     * 添加供货商
     */
    public void addMau() {
        while (true) {
            System.out.println("请输入供应商名称");
            String mauname = scanner.nextLine();
            if (StringUtil.isEmpty(mauname)) {
                System.out.println("输入内容为空！重新输入！");
                continue;
            }

            System.out.println("请输入手机号");
            String phone = scanner.nextLine();
            if (StringUtil.isEmpty(phone)) {
                System.out.println("输入内容为空！重新输入！");
                continue;
            }

            System.out.println("请输入地址");
            double address = scanner.nextDouble();
            scanner.nextLine();
            if (address < 0) {
                System.out.println("非法的数据！重新输入！");
                continue;
            }

            System.out.println("请输入邮政编码");
            double postcode = scanner.nextDouble();
            scanner.nextLine();
            if (postcode < 0) {
                System.out.println("非法的数据！重新输入！");
                continue;
            }
            Mau mau = new Mau(mauname, phone, address, postcode);
            mapper.insert(mau);
            sqlSession.commit();
            System.out.println("插入成功");
            break;
        }
    }

    /**
     * 删除供应商
     */
    public void delete() {
        System.out.println("请输入供应商id");
        int id = scanner.nextInt();
        if (id < 0) {
            System.out.println("非法的输入！");
            return;
        }
        mapper.delete(id);
        sqlSession.commit();
        System.out.println("操作成功");
    }

    /**
     * 模糊查询
     */
    public void select() {
        System.out.println("请输入供应商名称（模糊）");
        String name = scanner.nextLine();
        if (StringUtil.isEmpty(name)) {
            System.out.println("输入为空！");
            return;
        }
        List<Mau> maus = mapper.select(name);
        System.out.println("id\tmauname\tphone\taddress\tpostcode\tcreatetime");
        for (Mau mau : maus) {
            System.out.println(mau.getId()+"\t"+mau.getMauname()+"\t\t"+mau.getPhone()+"\t\t"+mau.getAddress()+"\t"+mau.getPostcode()+"\t\t"+simpleDate.format(mau.getCreatetime()));
        }
    }

    /**
     * 获取供应商所有产品
     */
    public void getAllProduct() {
        System.out.println("请输入供应商id");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id < 0) {
            System.out.println("非法的输入！");
            return;
        }
        String phone = mapper.getPhoneById(id);
        List<Product> products = mapper.getAllProducts(phone);
        System.out.println("id\tproductname\tmid\tproducecount\tproductprice\tcreatedate\tstatus");
        for (Product product : products) {
            System.out.println(product.getId()+"\t"+product.getProductname()+"\t\t"+product.getMid()+"\t\t"+product.getProductprice()+"\t"+simpleDate.format(product.getCreatetime())+"\t"+product.getStatus());
        }
    }
}
