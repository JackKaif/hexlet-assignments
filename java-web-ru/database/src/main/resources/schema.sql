-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    title varchar(255),
    price INT
);
-- END
