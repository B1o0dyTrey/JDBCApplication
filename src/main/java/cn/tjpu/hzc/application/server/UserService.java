package cn.tjpu.hzc.application.server;

import cn.tjpu.hzc.application.dao.UserMapper;
import cn.tjpu.hzc.application.domain.User;
import cn.tjpu.hzc.application.config.MybatisConfig;
import cn.tjpu.hzc.application.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Trey
 * @since 2020/12/8
 */

public class UserService {

    private final SqlSession sqlSession = MybatisConfig.sqlSession;
    public final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 用户登录数据
     */
    private User user;
    private Scanner scanner = new Scanner(System.in);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 登录
     */
    public void login() {
        while (true) {
            System.out.println("请输入用户名");
            String username = scanner.nextLine();
            if (StringUtil.isEmpty(username)) {
                System.out.println("输入内容为空");
                continue;
            }
            if ("admin".equals(username)) {
                System.out.println("请输入密码");
                String password = scanner.nextLine();
                if ("123456".equals(password)) {
                    System.out.println("欢迎管理员！");
                    this.user = new User();
                    this.user.setUsertype(0);
                    this.user.setName("admin");
                    break;
                }
            }
            System.out.println("请输入密码");
            String password = scanner.nextLine();
            if (StringUtil.isEmpty(password)) {
                System.out.println("输入内容为空");
                continue;
            }
            User user = mapper.login(username, password);
            if (user == null) {
                System.out.println("账号或密码错误");
                continue;
            }
            this.user = user;
            System.out.println("登陆成功！欢迎"+user.getName());
            break;
        }
    }

    /**
     * 新增用户
     * 需要管理员权限
     */
    public void addUser() {
        while (true) {
            System.out.println("请输入用户名：");
            String name = scanner.nextLine();
            if (StringUtil.isEmpty(name)) {
                System.out.println("请重新输入");
                continue;
            }

            System.out.println("请输入用户类型：1：员工、2：用户");
            int usertype = scanner.nextInt();
            if (!(usertype == 1 || usertype == 2)) {
                System.out.println("非法的数据");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            System.out.println("请输入用户密码：");
            String userpwd = scanner.nextLine();
            if (StringUtil.isEmpty(userpwd)) {
                System.out.println("请重新输入");
                continue;
            }

            System.out.println("请输入用户手机号");
            String phone = scanner.nextLine();
            if (StringUtil.isEmpty(phone)) {
                System.out.println("请重新输入");
                continue;
            }
            User user = new User(name,usertype,userpwd, phone,new Date(),1);
            mapper.addUser(user);
            sqlSession.commit();
            System.out.println("插入完成");
            break;
        }
    }

    /**
     * 修改用户
     */
    public void modify() {
        while (true) {
            System.out.println("请输入要修改的用户id");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("请输入用户名：");
            String name = scanner.nextLine();
            if (StringUtil.isEmpty(name)) {
                System.out.println("请重新输入");
                continue;
            }

            System.out.println("请输入用户类型：1：员工、2：用户");
            int usertype = scanner.nextInt();
            if (!(usertype == 1 || usertype == 2)) {
                System.out.println("非法的数据");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            System.out.println("请输入用户密码：");
            String userpwd = scanner.nextLine();
            if (StringUtil.isEmpty(userpwd)) {
                System.out.println("请重新输入");
                continue;
            }

            System.out.println("请输入用户手机号");
            String phone = scanner.nextLine();
            if (StringUtil.isEmpty(phone)) {
                System.out.println("请重新输入");
                continue;
            }
            System.out.println("请输入状态码：0或1");
            int status = scanner.nextInt();
            scanner.nextLine();
            if (!(status == 0 || status == 1)) {
                System.out.println("非法的数据");
                scanner.nextLine();
                continue;
            }
            User user = new User(name,usertype,userpwd, phone,null,status);
            user.setId(id);
            mapper.modify(user);
            sqlSession.commit();
            System.out.println("修改完成");
            break;
        }
    }

    /**
     * 查询所有用户
     */
    public void selectAll() {
        List<User> users = mapper.selectAll();
        System.out.println("id\tname\tusertype\tuserpwd\tuserphone\tcreatedate\tstatus");
        for (User user : users) {
            System.out.println(user.getId()+"\t"+user.getName()+"\t\t"+user.getUsertype()+"\t\t"+user.getUserpwd()+"\t"+user.getUserphone()+"\t"+simpleDate.format(user.getCreatedate())+"\t"+user.getStatus());
        }
    }
}
