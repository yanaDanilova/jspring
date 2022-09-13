BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR(255), price int, weight int);
INSERT INTO products (name, price,weight) VALUES
('T-Shirt', 25,100),
('Jeans', 70,250),
('Dress', 150, 150);

COMMIT;