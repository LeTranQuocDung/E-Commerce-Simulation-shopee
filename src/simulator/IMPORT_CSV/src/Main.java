import importer.*;

public class Main {
    public static void main(String[] args) {

        UserImporter.run("data/users.csv");
        ShopImporter.run("data/shops.csv");
        ProductImporter.run("data/products.csv");
        ProductVariantImporter.run("data/product_variants.csv");
        OrderImporter.run("data/orders.csv");
        OrderItemImporter.run("data/order_items.csv");
        VoucherImporter.run("data/vouchers.csv");

        System.out.println("IMPORT DONE");
    }
}
