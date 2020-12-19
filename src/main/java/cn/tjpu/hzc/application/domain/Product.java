package cn.tjpu.hzc.application.domain;

import java.sql.Date;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class Product {
    private int id;
    private String productname;
    private String mid;
    private double producecount;
    private double productprice;
    private Date createtime;
    private int status;


    public Product(String productname, String mid, double producecount, double productprice, Date createtime,int status) {
        this.productname = productname;
        this.mid = mid;
        this.producecount = producecount;
        this.productprice = productprice;
        this.createtime = createtime;
        this.status = status;
    }

    public Product() {
    }

    public Product(int id, String productname, String mid, double producecount, double productprice, Date createtime,int status) {
        this.id = id;
        this.productname = productname;
        this.mid = mid;
        this.producecount = producecount;
        this.productprice = productprice;
        this.createtime = createtime;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public double getProducecount() {
        return producecount;
    }

    public void setProducecount(double producecount) {
        this.producecount = producecount;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
