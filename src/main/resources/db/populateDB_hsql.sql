DELETE FROM item;
DELETE FROM invoice;
DELETE FROM product;
DELETE FROM customer;
DELETE FROM seller;

INSERT INTO customer (first_name, last_name, street, postal_code, city, country) VALUES ('Иван', 'Иванов', 'Советская', '125330', 'Москва', 'Россия');
INSERT INTO customer (first_name, last_name, street, postal_code, city, country) VALUES ('Петр', 'Петров', 'Зенитчиков', '125340', 'Москва', 'Россия');

INSERT INTO seller (name, street, postal_code, city, country) VALUES ('ПАО ФЛЭКС', 'Гагарина', '125320', 'Москва', 'Россия');
INSERT INTO seller (name, street, postal_code, city, country) VALUES ('ИП ИВАНОВ', 'Тушинская', '125360', 'Москва', 'Россия');

INSERT INTO product (name, price, vat) VALUES ('Планшет', '30000', '12');
INSERT INTO product (name, price, vat) VALUES ('Телефон', '10000', '11');
INSERT INTO product (name, price, vat) VALUES ('Ноутбук', '45000', '10');

INSERT INTO invoice (invoice_date, seller_id, customer_id) VALUES ('2017-12-20', '1', '1');
INSERT INTO invoice (invoice_date, seller_id, customer_id) VALUES ('2017-12-23', '2', '2');
INSERT INTO invoice (invoice_date, seller_id, customer_id) VALUES ('2017-12-24', '2', '1');

INSERT INTO item (invoice_id, product_id, number, quantity) VALUES ('1', '1', '1', '1');
INSERT INTO item (invoice_id, product_id, number, quantity) VALUES ('2', '2', '1', '3');
INSERT INTO item (invoice_id, product_id, number, quantity) VALUES ('3', '3', '1', '2');
INSERT INTO item (invoice_id, product_id, number, quantity) VALUES ('3', '1', '2', '5');
INSERT INTO item (invoice_id, product_id, number, quantity) VALUES ('2', '1', '2', '1');