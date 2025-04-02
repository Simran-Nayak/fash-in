CREATE SCHEMA fash_in;

use fash_in;

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL, 
    user_email VARCHAR(255) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_phone VARCHAR(20),
    user_address TEXT,
    user_role ENUM('USER','ADMIN') DEFAULT 'USER',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);



CREATE TABLE category (
    category_id VARCHAR(255) PRIMARY KEY ,
    category_title VARCHAR(255) NOT NULL,
    category_description TEXT NULL,
    category_price DECIMAL(10,2) NOT NULL,
    category_image_url TEXT NOT NULL,
    category_status ENUM ('ACTIVE','INACTIVE') DEFAULT 'ACTIVE'
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

CREATE TABLE order_table (
    order_id VARCHAR PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    order_status ENUM('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED','CART') DEFAULT 'PENDING',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE order_list (
    order_id VARCHAR PRIMARY KEY,
    order_item_id VARCHAR(255) PRIMARY KEY,
    user_id INT NOT NULL,
    order_date DATE NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    order_item_unit_price DECIMAL(10,2) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (order_id) REFERENCES order(id)ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(id)ON DELETE CASCADE
);

CREATE TABLE review (
    review_id VARCHAR(255) PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    rating INT NOT NULL CHECK (Rating >= 1 AND Rating <= 5),
    review_text TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES Product(id)ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(id)ON DELETE CASCADE
);

CREATE TABLE payment (
    payment_id VARCHAR(255) PRIMARY KEY,
    order_id VARCHAR NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    amount_paid DECIMAL(10, 2) NOT NULL,
    payments VARCHAR(255) NOT NULL CHECK Payments IN ('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') DEFAULT'PENDING',
    transaction_id VARCHAR(255) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(id)ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES order(id)ON DELETE CASCADE
);

CREATE TABLE wishlist (
    wishlist_id VARCHAR PRIMARY KEY,
    user_id INT NOT NULL,
    product_id VARCHAR NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE CASCADE
);
CREATE TABLE product (
    product_id VARCHAR PRIMARY KEY,
    category_id VARCHAR(255) NOT NULL,
    product_title VARCHAR(255) NOT NULL,
    product_description TEXT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    product_stock_quantity INT NOT NULL CHECK (product_stock_quantity >= 0),
    product_image_url TEXT NOT NULL,
    product_status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE widget (
    widget_id VARCHAR(255) PRIMARY KEY,        
    widget_name VARCHAR(255) NOT NULL, 
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

