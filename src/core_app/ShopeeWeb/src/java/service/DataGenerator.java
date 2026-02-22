package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenerator {

    private static final String FOLDER = "C:/data/";
    private static final Random rand = new Random();

    // --- CẤU HÌNH SỐ LƯỢNG ---
    private static final int TOTAL_USERS = 100;
    private static final int TOTAL_SHOPS = 20;
    private static final int TOTAL_PRODUCTS = 100;
    private static final int TOTAL_VARIANTS = 300;
    private static final int TOTAL_ORDERS = 200;
    private static final int TOTAL_ITEMS = 500;

    // --- POOL DỮ LIỆU LOGIC ---
    // Cấu trúc: {Category_ID, Loại sản phẩm, Thương hiệu 1, Thương hiệu 2, ..., Giá sàn (triệu đồng)}
    private static final String[][] CATEGORY_GROUPS = {
        {"2", "Dien thoai", "iPhone", "Samsung", "Xiaomi", "Oppo", "5"},       // 2: Điện Thoại & Phụ Kiện
        {"4", "Laptop", "Dell", "Macbook", "Asus", "HP", "10"},                // 4: Máy tính & Laptop
        {"1", "Ao thun", "Coolmate", "Zara", "Uniqlo", "0.2"},                 // 1: Thời Trang Nam
        {"1", "Quan Jean", "Zara", "Levis", "GenZ", "0.3"},                    // 1: Thời Trang Nam
        {"1", "Giay Sneaker", "Nike", "Adidas", "Bitis", "0.5"},               // 1: Thời Trang Nam
        {"3", "Tai nghe", "Sony", "JBL", "Apple", "Samsung", "0.5"},           // 3: Thiết Bị Điện Tử
        {"6", "Son moi", "Gucci", "3CE", "MAC", "0.4"},                        // 6: Nhà cửa & Đời sống (Mỹ phẩm)
        {"6", "Kem chong nang", "Anessa", "La Roche-Posay", "Skin1004", "0.3"},// 6: Nhà cửa & Đời sống
        {"5", "Dong ho", "Casio", "Rolex", "Citizen", "1"}                     // 5: Đồng hồ
    };

    private static final String[] ADJECTIVES = {"Cao cap", "Gia re", "Chinh hang", "Sieu ben", "Moi 100%", "Fullbox", "Xach tay", "Giam gia soc", "Limited Edition"};
    
    private static final String[] HO = {"Nguyen", "Tran", "Le", "Pham", "Hoang", "Huynh", "Phan", "Vu", "Vo", "Dang"};
    private static final String[] DEM = {"Van", "Thi", "Minh", "Duc", "My", "Ngoc", "Quang"};
    private static final String[] TEN = {"Anh", "Tuan", "Dung", "Hung", "Long", "Lan", "Mai", "Hoa", "Trang", "Linh"};

    private static final String[] IMAGES = {
        "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ll1rvl5558973e",
        "https://down-vn.img.susercontent.com/file/sg-11134201-22100-s6q7y2y2mhivda",
        "https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljz6j5j5j5j5j5",
        "https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lk3z5x5x5x5x5x"
    };

    private static final SimpleDateFormat dfStd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        new File(FOLDER).mkdirs();
        System.out.println("Dang tao data moi voi logic category...");

        genUsers(TOTAL_USERS);
        genShops(TOTAL_SHOPS);
        genProducts(TOTAL_PRODUCTS);
        genVariants(TOTAL_VARIANTS);
        genVouchers(50);
        genOrders(TOTAL_ORDERS, TOTAL_USERS);
        genOrderItems(TOTAL_ITEMS, TOTAL_ORDERS, TOTAL_VARIANTS);

        System.out.println("DA TAO XONG FILE CSV TAI: " + FOLDER);
    }

    private static BufferedWriter getWriter(String filename) throws Exception {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FOLDER + filename), StandardCharsets.UTF_8));
    }

    // 1. GEN USER
    private static void genUsers(int count) {
        try (BufferedWriter bw = getWriter("users.csv")) {
            bw.write("id,full_name,email,phone,wallet,password_hash,note");
            bw.newLine();
            for (int i = 1; i <= count; i++) {
                String fullName = getRandom(HO) + " " + getRandom(DEM) + " " + getRandom(TEN);
                String email = "user" + i + "@gmail.com";
                String phone = "09" + String.format("%08d", rand.nextInt(100000000));
                bw.write(i + "," + fullName + "," + email + "," + phone + "," + (rand.nextInt(500) * 10000) + ",123456,Khach moi");
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 2. GEN PRODUCTS (CÓ CATEGORY_ID)
    private static void genProducts(int count) {
        try (BufferedWriter bw = getWriter("products.csv")) {
            // Header giờ có thêm category_id
            bw.write("id,shop_id,category_id,name,description,price,image_url");
            bw.newLine();
            for (int i = 1; i <= count; i++) {
                String[] group = CATEGORY_GROUPS[rand.nextInt(CATEGORY_GROUPS.length)];
                
                String categoryId = group[0];
                String type = group[1];
                String brand = group[rand.nextInt(group.length - 3) + 2];
                
                double basePrice = Double.parseDouble(group[group.length - 1]) * 1000000;
                double finalPrice = basePrice + (rand.nextInt(100) * 10000);

                String name = type + " " + brand + " " + getRandom(ADJECTIVES) + " - Ma " + i;
                String img = getRandom(IMAGES);
                int shopId = rand.nextInt(TOTAL_SHOPS) + 1;

                // Ghi vào CSV có cột categoryId
                bw.write(i + "," + shopId + "," + categoryId + "," + name + ",Mo ta san pham " + i + "," + finalPrice + "," + img);
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 3. GEN VARIANTS
    private static void genVariants(int count) {
        try (BufferedWriter bw = getWriter("product_variants.csv")) {
            bw.write("id,product_id,color,size,stock,price,note");
            bw.newLine();
            String[] colors = {"Den", "Trang", "Xanh", "Do"};
            String[] sizes = {"S", "M", "L", "XL", "256GB", "512GB"};

            for (int i = 1; i <= count; i++) {
                int prodId = rand.nextInt(TOTAL_PRODUCTS) + 1;
                int stock = rand.nextInt(50) + 1;
                double price = (rand.nextInt(100) + 1) * 10000;
                bw.write(i + "," + prodId + "," + getRandom(colors) + "," + getRandom(sizes) + "," + stock + "," + price + ",");
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 4. GEN ORDERS
    private static void genOrders(int count, int maxUserId) {
        try (BufferedWriter bw = getWriter("orders.csv")) {
            bw.write("id,user_id,total_amount,created_at");
            bw.newLine();
            long now = System.currentTimeMillis();
            for (int i = 1; i <= count; i++) {
                int userId = rand.nextInt(maxUserId) + 1;
                long randomTime = now - (long) (rand.nextDouble() * 30L * 24 * 60 * 60 * 1000);
                bw.write(i + "," + userId + "," + ((rand.nextInt(50) + 5) * 50000) + "," + dfStd.format(new Date(randomTime)));
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 5. GEN ORDER ITEMS
    private static void genOrderItems(int count, int maxOrderId, int maxVariantId) {
        try (BufferedWriter bw = getWriter("order_items.csv")) {
            bw.write("id,order_id,variant_id,quantity,price_at_purchase");
            bw.newLine();
            for (int i = 1; i <= count; i++) {
                bw.write(i + "," + (rand.nextInt(maxOrderId) + 1) + "," + (rand.nextInt(maxVariantId) + 1) + ",1,100000");
                bw.newLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    // 6. GEN SHOPS & VOUCHERS
    private static void genShops(int c) {
        try (BufferedWriter w = getWriter("shops.csv")) {
            w.write("id,shop_name,rating\n");
            for (int i = 1; i <= c; i++) {
                w.write(i + ",Shop " + i + " Official," + String.format("%.1f", (3.5 + rand.nextDouble() * 1.5)) + "\n");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void genVouchers(int c) {
        try (BufferedWriter w = getWriter("vouchers.csv")) {
            w.write("code,value,min_order,start_date,end_date\n");
            for (int i = 1; i <= c; i++) {
                w.write("VOUCHER" + i + ",20000,100000,2026-01-01,2026-12-31\n");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static String getRandom(String[] arr) {
        return arr[rand.nextInt(arr.length)];
    }
}