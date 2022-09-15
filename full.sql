BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR(255), price int, weight int);
INSERT INTO products (name, price,weight) VALUES
('T-Shirt', 25,100),
('Jeans', 70,250),
('Dress', 150, 150);

COMMIT;

BEGIN;

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('John'),
('Mary'),
('Max');

COMMIT;

DROP TABLE IF EXISTS customers_products CASCADE;
CREATE TABLE customers_products (customer_id bigint, product_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO customers_products (customer_id, product_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(1, 3),
(3, 2);