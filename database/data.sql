USE fash_in;

INSERT INTO product (
    user_id, name, product_category, category_id, seller_id, product_title, 
    product_price, product_stock_quantity, product_image_url, product_status, 
    created_by, updated_by
) VALUES 
(1, 'Men T-Shirt', 'Clothing', 1, 2, 'Stylish Cotton T-Shirt', 19.99, 50, 'https://example.com/tshirt.jpg', 'ACTIVE', 'admin', 'admin'),
(2, 'Women Handbag', 'Accessories', 2, 3, 'Luxury Leather Handbag', 79.99, 30, 'https://example.com/handbag.jpg', 'ACTIVE', 'admin', 'admin'),
(3, 'Smart Watch', 'Electronics', 3, 4, 'Latest Smart Watch 2024', 199.99, 20, 'https://example.com/smartwatch.jpg', 'INACTIVE', 'admin', 'admin');
