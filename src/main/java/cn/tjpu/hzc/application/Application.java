package cn.tjpu.hzc.application;

import cn.tjpu.hzc.application.domain.User;
import cn.tjpu.hzc.application.server.MauService;
import cn.tjpu.hzc.application.server.ProductService;
import cn.tjpu.hzc.application.server.UserService;
import cn.tjpu.hzc.application.util.StringUtil;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.logging.SimpleFormatter;

public class Application {

    public static void main(String[] args) throws IOException {
        UserService userService = new UserService();
        userService.login();
        ProductService productService = new ProductService();
        MauService mauService = new MauService();
        menu(userService,mauService,productService);
    }

    private static void menu(UserService userService, MauService mauService, ProductService productService) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int usertype = userService.getUser().getUsertype();
        while (true) {
            if (usertype == 0) {
                employer();
                user();
                admin();
            }
            if (usertype == 1) {
                employer();
                user();
            }
            if (usertype == 2) {
                user();
            }
            String flag = scanner.nextLine();
            if (StringUtil.isEmpty(flag)) {
                System.out.println("输入为空!重新输入");
                continue;
            }
            if ("1".equals(flag)) {
                mauService.getAll();
            }
            if ("2".equals(flag)) {
                mauService.addMau();
            }
            if ("3".equals(flag)) {
                mauService.delete();
            }
            if ("4".equals(flag)) {
                mauService.select();
            }
            if ("5".equals(flag)) {
                mauService.getAllProduct();
            }
            if ("6".equals(flag)) {
                productService.getAll();
            }
            if ("7".equals(flag)) {
                productService.addProduct();
            }
            if ("8".equals(flag)) {
                productService.delete();
            }
            if ("9".equals(flag)) {
                productService.LogicallyUpdate();
            }
            if ("10".equals(flag)) {
                productService.select();
            }
            if ("11".equals(flag)) {
                productService.purchase();
            }
            if ("12".equals(flag)) {
                productService.getMauById();
            }
            if ("13".equals(flag)) {
                Application.ouputExcel(userService);
            }
            if ("14".equals(flag)) {
                userService.addUser();
            }
            if ("15".equals(flag)) {
                userService.modify();
            }
            if ("16".equals(flag)) {
                userService.selectAll();
            }
            if ("exit".equals(flag)) {
                break;
            }
        }
    }

    public static void admin() {
        //todo admin菜单
        System.out.println("9.上下架商品");
        System.out.println("14.增加新用户");
        System.out.println("15.修改用户");
        System.out.println("16.查询所有用户");
    }

    public static void employer() {
        //todo 雇员菜单
        System.out.println("1.查询所有供货商");
        System.out.println("2.添加供货商");
        System.out.println("3.删除供应商");
        System.out.println("4.模糊查询某个供货商");
        System.out.println("5.获取供货商所有商品");
        System.out.println("6.查询所有商品");
        System.out.println("7.添加商品");
        System.out.println("8.删除商品");
        System.out.println("10.模糊查询某个商品");
        System.out.println("12.根据商品id搜索供应商");
        System.out.println("13.将表格导出为excel");
    }

    public static void user() {
        System.out.println("11.购买商品");
    }

    static void ouputExcel(UserService userService) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<User> userList = userService.mapper.selectAll();
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "Id", "name", "usertype", "userpwd","userphone","createDate","status"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

         SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //在表中存放查询到的数据放入对应的列
        for (User user : userList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(user.getId());
            row1.createCell(1).setCellValue(user.getName());
            row1.createCell(2).setCellValue(user.getUsertype());
            row1.createCell(3).setCellValue(user.getUserpwd());
            row1.createCell(4).setCellValue(user.getUserphone());
            row1.createCell(5).setCellValue(simpleDate.format(user.getCreatedate()));
            row1.createCell(6).setCellValue(user.getStatus());
            rowNum++;
        }
        FileOutputStream fout = new FileOutputStream("E:/students.xls");
        workbook.write(fout);
    }
}
