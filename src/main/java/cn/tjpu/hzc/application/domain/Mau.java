package cn.tjpu.hzc.application.domain;

import java.sql.Date;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class Mau {
    private int id;
    private String mauname;
    private String phone;
    private double address;
    private double postcode;
    private Date createtime;

    public Mau(String mauname, String phone, double address, double postcode) {
        this.mauname = mauname;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
    }

    public Mau() {
    }

    public Mau(int id, String mauname, String phone, double address, double postcode, Date createtime) {
        this.id = id;
        this.mauname = mauname;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMauname() {
        return mauname;
    }

    public void setMauname(String mauname) {
        this.mauname = mauname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAddress() {
        return address;
    }

    public void setAddress(double address) {
        this.address = address;
    }

    public double getPostcode() {
        return postcode;
    }

    public void setPostcode(double postcode) {
        this.postcode = postcode;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
