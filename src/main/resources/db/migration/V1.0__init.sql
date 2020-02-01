DROP TABLE IF EXISTS PRODUCTS;

CREATE TABLE PRODUCTS (
  ID            INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NAME          VARCHAR(255) NOT NULL,
  CURRENT_PRICE DECIMAL(20, 2) NOT NULL,
  LAST_UPDATE    DATETIME
);