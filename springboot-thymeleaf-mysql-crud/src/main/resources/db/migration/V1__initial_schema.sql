-- V<Version>__<Description>.sql
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    madein VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL
);
