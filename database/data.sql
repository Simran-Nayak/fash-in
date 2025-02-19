USE fash_in;

INSERT INTO category (category_id, category_title, category_description, category_price, category_image_url, category_status, created_date, updated_date, created_by, updated_by) 
VALUES 
('CAT001', 'Men’s Shirts', 'A variety of casual and formal shirts', 29.99, 'https://example.com/images/mens-shirts.jpg', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
('CAT002', 'Women’s Dresses', 'Stylish and elegant dresses for women', 49.99, 'https://example.com/images/womens-dresses.jpg', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
('CAT003', 'Sportswear', 'Comfortable and durable sportswear', 39.99, 'https://example.com/images/sportswear.jpg', 'INACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
('CAT004', 'Footwear', 'Trendy and comfortable shoes', 59.99, 'https://example.com/images/footwear.jpg', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),
('CAT005', 'Accessories', 'Fashionable accessories like watches and bags', 19.99, 'https://example.com/images/accessories.jpg', 'INACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');
