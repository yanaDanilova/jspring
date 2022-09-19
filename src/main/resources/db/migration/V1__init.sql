BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR(255), price int, weight int);
INSERT INTO products (name, price,weight) VALUES
('T-Shirt', 25,100),
('Jeans', 70,250),
('Sweater',150, 50),
('Skirt',50,30),
('Coat',150, 300),
('Hat', 70, 57),
('Scarf',68, 40),
('Suit', 350, 370),
('Dress', 150, 150);

COMMIT;

