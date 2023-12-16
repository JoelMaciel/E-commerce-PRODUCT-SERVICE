set foreign_key_checks = 0;

delete from products;

set foreign_key_checks = 1;

INSERT INTO products (product_id, name, price, quantity) VALUES
('0c288c86-c1f3-4211-b59f-f1c52a4a5636', 'Laptop', 999.99, 10),
('4c416789-9995-405a-8183-a3278372679c', 'Smartphone', 499.99, 20),
('4d86abbe-d29f-455c-8fdc-c3e1102fe90c', 'Headphones', 79.99, 50);

