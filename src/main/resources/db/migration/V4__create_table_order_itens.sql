CREATE TABLE IF NOT EXISTS order_item (
        id INT NOT NULL AUTO_INCREMENT,
        orders_id INT NOT NULL,
        name VARCHAR(50) NOT NULL,
        price DOUBLE NOT NULL,
        quantity INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (orders_id) REFERENCES orders(id)
);
