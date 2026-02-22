package dal;

import java.util.concurrent.ConcurrentHashMap;

public class QrMemory {

    // Lưu trữ: Token -> Tên User (Nếu chưa quét thì null)
    public static ConcurrentHashMap<String, String> tokens = new ConcurrentHashMap<>();
}
