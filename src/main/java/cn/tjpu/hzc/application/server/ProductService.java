package cn.tjpu.hzc.application.server;

import cn.tjpu.hzc.application.dao.ProductMapper;
import cn.tjpu.hzc.application.config.MybatisConfig;
import cn.tjpu.hzc.application.domain.Product;
import cn.tjpu.hzc.application.domain.User;
import cn.tjpu.hzc.application.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class ProductService {
    private final SqlSession sqlSession = MybatisConfig.sqlSession;
    private final ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Scanner scanner = new Scanner(System.in);
    //todo 修改文件目录
    private static final String FILEPATH = "E:\\purchase.txt";
    /**
     * 查询所有商品
     */
    public void getAll() {
        List<Product> products = mapper.getAll();
        System.out.println("id\tproductname\tmid\tproducecount\tproductprice\tcreatedate\tstatus");
        for (Product product : products) {
            System.out.println(product.getId()+"\t"+product.getProductname()+"\t\t"+product.getMid()+"\t\t"+product.getProductprice()+"\t"+simpleDate.format(product.getCreatetime())+"\t"+product.getStatus());
        }
    }

    /**
     * 添加商品
     */
    public void addProduct() {
        while (true) {
            System.out.println("请输入商品名");
            String name = scanner.nextLine();
            if (StringUtil.isEmpty(name)) {
                System.out.println("输入为空！请重新输入");
                continue;
            }

            System.out.println("请输入供应商id");
            String mid = scanner.nextLine();
            if (StringUtil.isEmpty(mid)) {
                System.out.println("输入为空!请重新输入");
                continue;
            }

            System.out.println("请输入货物数量");
            int producecount = scanner.nextInt();
            scanner.nextLine();

            System.out.println("请输入货物价格");
            int productprice = scanner.nextInt();
            scanner.nextLine();
            if (productprice <= 0) {
                System.out.println("非法的数据!请重新输入");
                continue;
            }

            System.out.println("请设置商品状态：0下架，1售卖中");
            int status = scanner.nextInt();
            scanner.nextLine();
            if (!(status == 0 || status == 1)) {
                System.out.println("非法的数据!请重新输入");
                continue;
            }
            Product product = new Product(name, mid, producecount, productprice, null, status);
            mapper.addProduct(product);
            sqlSession.commit();
            System.out.println("插入完成");
            break;
        }
    }

    /**
     * 删除商品
     */
    public void delete() {
        System.out.println("请输入需要删除的商品id");
        int id = scanner.nextInt();
        scanner.nextLine();
        mapper.delete(id);
        sqlSession.commit();
    }

    /**
     * 上下架商品
     */
    public void LogicallyUpdate() {
        System.out.println("请输入需要下架的商品id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入需要下架的商品id");
        int status = scanner.nextInt();
        scanner.nextLine();
        mapper.logicallyUpdate(id,status);
        sqlSession.commit();
    }

    /**
     * 模糊查询
     */
    public void select() {
        System.out.println("请输入需要查询的商品");
        String productName = scanner.nextLine();
        if (StringUtil.isEmpty(productName)) {
            System.out.println("输入为空！请重新输入");
            return;
        }
        List<Product> products = mapper.select(productName);
        System.out.println("id\tproductname\tmid\t\tproducecount\tproductprice\tcreatedate\t\t\tstatus");
        for (Product product : products) {
            System.out.println(product.getId()+"\t"+product.getProductname()+"\t\t"+product.getMid()+"\t\t"+product.getProducecount()+"\t\t\t"+product.getProductprice()+"\t\t\t"+simpleDate.format(product.getCreatetime())+"\t"+product.getStatus());
        }
    }

    /**
     * 采购
     */
    public void purchase() throws IOException {
        int amount = 0;
        File purchase = new File(FILEPATH);
        if (!purchase.exists()) {
            try {
                purchase.createNewFile();
            } catch (IOException e) {
                System.out.println("something wrong!");
            }
        }
        Writer writer = new OutputStreamWriter(new FileOutputStream(FILEPATH), StandardCharsets.UTF_8);
        while (true) {
            System.out.println("请输入要购买的商品id");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id < 0) {
                System.out.println("非法的id，请重新输入");
                continue;
            }
            System.out.println("请输入要购买的商品数量");
            int count = scanner.nextInt();
            scanner.nextLine();
            if (count < 0) {
                System.out.println("非法的数量，请重新输入");
                continue;
            }
            mapper.purchase(count,id);
            sqlSession.commit();
            Product product = mapper.getNameById(id);
            String productName = product.getProductname();
            double mount = product.getProductprice();
            amount += mount*count;
            writer.write(productName+"\t\t"+mount+"$\t\t"+count+"\n");
            System.out.println("是否继续购买？yes or no");
            String isContinue = scanner.nextLine();
            if (!"yes".equals(isContinue)) {
                break;
            }
        }
        writer.write("总计："+amount);
        writer.close();
    }

    /**
     * 根据商品id搜索供应商
     */
    public void getMauById() {
        System.out.println("请输入商品id");
        int id = scanner.nextInt();
        scanner.nextLine();
        String mid = mapper.getMidById(id);
        String mauname = mapper.getMauByMid(mid);
        System.out.println("供应商id：" + mauname);
    }
}
