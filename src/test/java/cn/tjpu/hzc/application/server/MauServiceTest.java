package cn.tjpu.hzc.application.server;

import junit.framework.TestCase;

public class MauServiceTest extends TestCase {

    public void testGetAll() {
        MauService service = new MauService();
        service.getAll();
    }

    public void testAddMau() {
        MauService service = new MauService();
        service.addMau();
    }

    public void testDelete() {
        MauService service = new MauService();
        service.delete();
    }

    public void testSelect() {
        MauService service = new MauService();
        service.select();
    }

    public void testGetAllProduct() {
        MauService service = new MauService();
        service.getAllProduct();
    }
}