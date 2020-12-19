package cn.tjpu.hzc.application;

import cn.tjpu.hzc.application.server.UserService;
import junit.framework.TestCase;

import java.io.IOException;

public class ApplicationTest extends TestCase {

    public void testOuputExcel() throws IOException {
        UserService service = new UserService();
        Application.ouputExcel(service);
    }
}