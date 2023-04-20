CREATE TABLE IF NOT EXISTS orders (
    id INT NOT NULL AUTO_INCREMENT,
    customers_id BIGINT UNSIGNED NOT NULL,
    status VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (customers_id) REFERENCES customers(id)
);
