USE ShopeeDB;
GO

-- 1. Xem những sản phẩm bị lỗi Kho/Giá đã được sửa
SELECT id, stock, price, note 
FROM ProductVariants 
WHERE note IS NOT NULL AND note <> '';

-- 2. Xem những User bị lỗi Email/SĐT đã được sửa
SELECT id, full_name, email, phone, note 
FROM Users 
WHERE note IS NOT NULL AND note <> '';

-- 3. Xem đơn hàng bị sai ngày tháng đã được sửa
SELECT id, created_at, note 
FROM Orders 
WHERE note IS NOT NULL AND note <> '';