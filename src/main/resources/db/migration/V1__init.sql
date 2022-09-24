BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR(255), price int);
INSERT INTO products (name, price) VALUES
('T-Shirt', 25),
('Jeans', 70),
('Sweater',150),
('Skirt',50),
('Coat',150),
('Hat', 70),
('Scarf',68),
('Suit', 350),
('Dress', 150);

COMMIT;

