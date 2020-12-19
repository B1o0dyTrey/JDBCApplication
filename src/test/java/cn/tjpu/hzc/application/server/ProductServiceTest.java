package cn.tjpu.hzc.application.server;

import junit.framework.TestCase;

import java.io.IOException;

public class ProductServiceTest extends TestCase {

    public void testAddProduct() {
        ProductService service = new ProductService();
        service.addProduct();
    }

    public void testSelect() {
        ProductService service = new ProductService();
        service.select();
    }

    public void testDelete() {
        ProductService service = new ProductService();
        service.delete();
    }

    public void testPurchase() throws IOException {
        ProductService service = new ProductService();
        service.purchase();
    }

    public void testGetMauById() {
        ProductService service = new ProductService();
        service.getMauById();
    }
}