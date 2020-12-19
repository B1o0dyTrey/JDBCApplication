package cn.tjpu.hzc.application.domain;


import java.util.Date;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class User {
    private int id;
    private String name;
    private int usertype;
    private String userpwd;
    private String userphone;
    private Date createdate;
    private int status;

    public User(String name, int usertype, String userpwd, String userphone, Date createdate, int status) {
        this.name = name;
        this.usertype = usertype;
        this.userpwd = userpwd;
        this.userphone = userphone;
        this.createdate = createdate;
        this.status = status;
    }

    public User() {
    }

    public User(int id, String name, int usertype, String userpwd, String userphone, Date createdate, int status) {
        this.id = id;
        this.name = name;
        this.usertype = usertype;
        this.userpwd = userpwd;
        this.userphone = userphone;
        this.createdate = createdate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
