package cn.tjpu.hzc.application.server;

import org.junit.Test;
public class UserServiceTest {

    @Test
    public void login() {
        UserService service = new UserService();
        service.login();
    }

    @Test
    public void addUser() {
        UserService service = new UserService();
        service.addUser();
    }

}