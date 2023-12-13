set foreign_key_checks = 0;

delete from products;

set foreign_key_checks = 1;

INSERT INTO products (product_id, name, price, quantity) VALUES
('6f27693b-be69-41c8-9aff-26debe0cde2d', 'Laptop', 999.99, 10),
('aa01255b-5121-4461-bf91-7645dc833660', 'Smartphone', 499.99, 20),
('f272e5a3-f514-4213-811a-29cc2db888f0', 'Headphones', 79.99, 50);
